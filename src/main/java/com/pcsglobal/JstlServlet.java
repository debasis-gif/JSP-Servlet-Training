// Servlet with JSTL tag
// Servlet with Jstl calling object

package com.pcsglobal;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name = "Debasis Welcome!!!";
		
		// Calling object Student OR creating an Arraylist of Students objects
		List<Student> stud = Arrays.asList(new Student(1, "Debasis"), new Student(2, "Navin"), new Student(3, "Arati"));
		// Student stud = new Student(1, "Debasis");
		
		// req.setAttribute("label", name);
		
		// setting Student object 
		req.setAttribute("student", stud);
		
		RequestDispatcher rd = req.getRequestDispatcher("JstlDisplay.jsp");
		rd.forward(req, res);
	}
}
