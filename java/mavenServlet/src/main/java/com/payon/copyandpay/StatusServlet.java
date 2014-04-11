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

	private static final String SUCCESS_PAGE = WEB_DIR + "paymentSuccess.jsp";
	private static final String FAILURE_PAGE = WEB_DIR + "paymentError.jsp";

	
}
