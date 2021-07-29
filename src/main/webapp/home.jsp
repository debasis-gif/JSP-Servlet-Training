<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Page Directive include -->
<%@ page errorPage="error.jsp" %>

<!-- Include Directive include -->
<%@ include file="index7.html" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Include Directive</title>
</head>
<body>
	<%
		pageContext.setAttribute("name", "Debasis", PageContext.SESSION_SCOPE); 
		// the attribute name with value Debasis will be available for all the pages of the entire session
		// and not restricted to the current page only
		// the pageContext is the JSP object provided by Tomcat from PageContext Class/object of Tomcat
		
		config.getInitParameter("name");
		// Similarly we do not need to instantiate the ServletConfig (interface) object in Servlet, 
		// as Tomcat provides the config object in JSP
	%>
	
<!-- Exception handling in JSP -->

	<%
		/* try { int k = 9/0; }catch(Exception e){out.println("Error: " + e.getMessage());} */
		// unchecked error introduced -> division by zero. If run like this it will encounter error 500 on browser
		// We can do the java exception handling using try catch, but the output will be on the same page in browser, 
		// which is not desirable
		// So, we introduce Directive tag <%@ page errorPage="err_url"
		
		int k = 9/0;
		// This will invoke error.jsp as per the page directive		
	%>
	
</body>
</html>