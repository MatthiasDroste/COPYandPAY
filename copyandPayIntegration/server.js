var http = require('https');
var fs = require('fs');
var url = require('url');
var requests = require('./requests');

var options = {
		key: fs.readFileSync('cert/testkey.pem'),
		cert: fs.readFileSync('cert/testcert.pem')
		};

http.createServer(options, function(request, response) {
	var urlObject = url.parse(request.url, true);
	console.log("got called with: " + urlObject.href);
	var pathname = urlObject.pathname;

	if (pathname === '/payment' || pathname === '' || pathname === '/') {
		requests.generateToken(function(token) {
			fs.readFile('payment.html', function(err, data) {
				var body = data.toString().replace('{token}', token);
				response.writeHead(200, {
					'Content-Type' : 'text/html',
					'Content-Length' : body.length
				});
				response.end(body);
			});

		});
	} else if (pathname === '/result') {
		if (urlObject.query.token !== null) {
			console.log("token is " + urlObject.query.token);
			requests.getStatus(urlObject.query.token, function(status) {
				var result = getResult(status);
				fs.readFile('result.html', function(err, data) {
					var body = data.toString().replace('{result}', result);
					response.writeHead(200, {
						'Content-Type' : 'text/html',
						'Content-Length' : body.length
					});
					response.end(body);
				});
			});
		} else {
			console.log("wrong call to result! I need a token-param!");
			response.end();
		}
	} else {
		console.log("not implemented: " + pathname);
		response.end();
	}
	
	/**
	 * expects a json-response, parses out the result-string
	 */
	function getResult(status) {
		if (status.errorMessage) {
			return status.errorMessage;
		} else if(status.transaction.processing.return.message) {
			return status.transaction.processing.return.message;
		}
		else {
			console.log(status.toString());
			return "error: unknown request structure";
		}
	}
	
}).listen(8181);

