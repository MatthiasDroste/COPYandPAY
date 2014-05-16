# mavenServlet

Minimal integration of COPYandPAY using a maven project with Servlets and jsp.

## Usage

**Prerequisites**: This guideline assumes that you have Eclipse with a maven plug-in (m2e), egit and JD K>= 1.6 installed, see the Tools section below for more info.

### Import the project to Eclipse: 

* Open the Git-Perspective. 
  * Click on the "clone a git repository" button, uri is https://github.com/PAYON-AG/COPYandPAY.git. 
  * (or if you cloned on the command line: click on "Add an existing local git repository".) 
* Rightclick on the mavenServlet-folder -> import projects -> import existing Projects -> Finish

### Run the project:

In the Java-Perspective, rightclick on project in the eclipse package explorer -> Run as -> Maven build -> enter in Goals: tomcat:run 

Call it on http://localhost:8080/mavenServlet/payment

You now should see an IllegalArgumentException("NOT IMPLEMENTED YET"). 
Great! Proceed to developing the PaymentServlet.java.

## Developing

Basically you just follow this tutorial: http://www.paysourcing.com/Integrationguide/COPYandPAY.html

* *PaymentServlet.java* does step 1 of the tutorial: it calls CreateToken and dispatches to the payment.jsp
* *payment.jsp* does step 2 of the tutorial: reads the token as a request attribute and displays the payment page. Configure the form to point to http://localhost:8080/mavenServlet/status and offer the brands VISA and MASTER
* *StatusServlet.java* does step 3 of the tutorial: receives the redirect of the user after payment. It calls GetStatus, evaluates it an dispatches to the paymentSuccess.jsp or paymentError.jsp.

### Once you are done
1.  Visa and MasterCard are shown at the checkout page
2.  A payment is done with Visa, eg. Name: use your name, Number:4200 0000 0000 0000, CVV:123, Expiry date 12/2014
3.  The result page http://localhost:8080/mavenServlet/status displays the result based on the json response.

### Tools

Created in Eclipse/Spring Tool Suite 3.5.0.RELEASE http://spring.io/tools/sts (also works when you just download the java edition from www.eclipse.org)

Maven project http://maven.org

Tomcat http://tomcat.apache.org/
