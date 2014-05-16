package com.payon.copyandpay;

import java.io.IOException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.jayway.jsonpath.JsonPath;

/**
 * This servlet handles calls to http://localhost:8080/mavenServlet/payment by
 * doing two things:<br>
 * 1. Generate a token<br>
 * 2. Load the payment.jsp-page with the token to display the payment form.
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 7025771436876538138L;

	private static final String PAYMENT_PAGE = "payment.jsp";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tokenResponse = generateToken();
		String token = JsonPath.read(tokenResponse, "$.transaction.token");

		// set token so that the JSP can use it with <%=token%>
		request.setAttribute("token", token);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher(PAYMENT_PAGE);
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * Step 1 of the COPYandPAY tutorial: Sends a request to the
	 * GenerateToken-URL and returns the JSON response.
	 */
	private String generateToken() {
		// TODO fill in the snippet from step 1 of the COPYandPAY tutorial http://www.paysourcing.com/Integrationguide/COPYandPAY.html here.
		throw new IllegalStateException("NOT IMPLEMENTED YET");
	}
}
