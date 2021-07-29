
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Page directive to import java.sql... -> Step 1 -->
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	101 <br/>
	Debasis <br/>
	88 <br/><br/>

	<%
		// JDBC connection using MySQL
		String url = "jdbc:mysql://localhost:3306/jsp";
		String uname = "root";
		String pwd = "password";
		String sql = "select * from jsp.students where rollno = ?";
		
		Class.forName("com.mysql.jdbc.Driver");   // Load and register jdbc driver for mysql -> Step 2
												  // Add the mysql-connector jar file into lib folder of WEB-INF
		
		Connection con = DriverManager.getConnection(url, uname, pwd); // Connect to mysql database -> Step 3
			
		// This portion is to check the PreparedStatement object
		PreparedStatement pstmt = con.prepareStatement(sql);   // creating the PreparedStatement object -> Step 4

		pstmt.setString(1, "103");
					
		ResultSet rs = pstmt.executeQuery();   // execute the query -> Step 5

		rs.next(); 		// process the data - that is browse through the resultset, fetch the data and print the result -> Step 6		
		
		int rownum = rs.getRow();
		
		out.println("No. of row(s): \n\n" +rownum);

	%>
	
	<!-- Print the fetched record -->
	<br/>
	<br/>Roll No.: <%= rs.getString(1) %>
	<br/>Name    : <%= rs.getString(2) %>
	<br/>Marks   : <%= rs.getString(3) %>

	
	<%
		con.close();   // Close the connection or release the resource -> Step 7	
	%>
	
</body>
</html>