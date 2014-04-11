package com.payon.copyandpay;

import java.io.IOException;
import java.net.URL;
import static com.payon.copyandpay.PaymentServlet.*;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.jayway.jsonpath.JsonPath;

public class StatusServlet extends HttpServlet {

	private static final long serialVersionUID = -7305728645317107693L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");

		URL url = new URL(
				"https://test.ctpe.net/frontend/GetStatus;jsessionid=" + token);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		String content = IOUtils.toString(conn.getInputStream());
		if ("ACK".equals(JsonPath.read(content,
				"$.transaction.processing.result"))) {
			request.getRequestDispatcher(WEB_DIR + "paymentSuccess.jsp")
					.forward(request, response);
		} else {
			request.getRequestDispatcher(WEB_DIR + "paymentError.jsp").forward(
					request, response);
		}
	}
}
