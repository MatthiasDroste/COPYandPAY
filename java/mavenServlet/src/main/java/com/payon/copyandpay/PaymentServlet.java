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

public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 7025771436876538138L;

	public static final String WEB_DIR = "/WEB-INF/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tokenResponse = generateToken();
		String token = JsonPath.read(tokenResponse, "$.transaction.token");
		request.setAttribute("token", token);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher(WEB_DIR + "payment.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	private String generateToken() {
		throw new IllegalStateException("not implemented yet");
	}
}
