package com.payon.copyandpay;

import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.jayway.jsonpath.JsonPath;

/**
 * This Servlet handles calls to http://localhost:8080/mavenServlet/status by doing two things:<br>
 * 1. Call GetStatus to receive the JSON-formatted payment result. 
 * 2. Evaluate the content of the JSON response and call the shop's success- or error-page.
 * 
 */
public class StatusServlet extends HttpServlet {

	private static final long serialVersionUID = -7305728645317107693L;

	//TODO fill in the snippet from step 3 of the COPYandPAY tutorial here.
	
}
