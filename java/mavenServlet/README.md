# mavenServlet

minimal integration of COPYandPAY using a maven project with Servlets and jsp.

## Usage

### Import the project: 

In "Git Repositories" view, rightclick on the mavenServlet-folder -> import projects -> import existing Projects -> Finish

### Run the project:

Rightclick on project in the eclipse package explorer -> Run as -> Maven build -> enter the target tomcat:run 

Call it on http://localhost:8080/mavenServlet/payment

## Developing

* *PaymentServlet.java* does step 1 of the tutorial: it calls CreateToken and dispatches to the payment.jsp
* *payment.jsp* does step 2 of the tutorial: reads the token as a request attribute and displays the payment page
* *StatusServlet.java* does step 3 of the tutorial: receives the redirect of the user after payment. It calls GetStatus, evaluates it an dispatches to the paymentSuccess.jsp or paymentError.jsp.

### Tools

Created in Eclipse/Spring Tool Suite 3.5.0.RELEASE http://spring.io/tools/sts

Maven project http://maven.org

Tomcat http://tomcat.apache.org/