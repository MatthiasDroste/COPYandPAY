/**
 * 1. send a generateToken (POST): 2. call getStatus(GET)
 */

var http = require('https');
var querystring = require('querystring');
var token;
function Options(method, path, params) {
	this.hostname = 'test.ctpe.net';
	this.port = 443;
	this.path = path;
	this.method = method;

	if (params) {
		this.headers = {
			'Content-Type' : 'application/x-www-form-urlencoded',
			'Content-Length' : Buffer.byteLength(params)
		};
	}
}

exports.getStatus = function(token, callback) {
	console.log("getstatus gets token: " + token);
	var options = new Options('GET', '/frontend/GetStatus;jsessionid=' + token);
	var req = http.request(options, function(res) {
		res.on('data', function(data) {
			console.log('getstatus response is ' + data);
			callback(JSON.parse(data));
		});
	});

	req.on('error', function(e) {
		console.error(e);
		callback("failed");
	});

	req.end();
};

exports.generateToken = function(callback) {

	var postParameters = querystring.stringify({
		'SECURITY.SENDER' : 'ff80808144ac32180144ac59a02500b3',
		'TRANSACTION.CHANNEL' : 'ff80808144ac32180144ac59a02a00be',
		'TRANSACTION.MODE' : 'INTEGRATOR_TEST',
		'USER.LOGIN' : 'ff80808144ac32180144ac59a02700b7',
		'USER.PWD' : 'demo',
		'PAYMENT.TYPE' : 'DB',
		'PRESENTATION.AMOUNT' : '1.99',
		'PRESENTATION.CURRENCY' : 'EUR'
	});

	var options = new Options('POST', '/frontend/GenerateToken', postParameters);
	var req = http.request(options, function(res) {
		res.on('data', function(data) {
			var response = JSON.parse(data);
			console.log('GenerateToken received token: '
					+ response.transaction.token);
			token = response.transaction.token;
			callback(token);
		});
	});

	req.on('error', function(e) {
		console.error(e);
		callback(null);
	});

	req.write(postParameters);
	req.end();
};