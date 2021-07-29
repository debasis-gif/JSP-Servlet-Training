package com.pcsglobal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class AddSqSessionCookie extends HttpServlet 
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int sum = i + j;
		
		// Here the app server provides the HttpSession, through the request object we get hold of the session
		// set the attribute to the session object and use the sendRedirect to call the other servlet with the attribute passed
		/*
		HttpSession session = req.getSession();
		session.setAttribute("sum", sum);
		*/
		
		// Here let's check the same operation but using Cookie
		// It is nothing but a token given to a transaction which can help remember the transaction with the client
		Cookie cookie = new Cookie("sum", sum + ""); 
		res.addCookie(cookie); 
		// Cookie is a Class which accepts both the arguments in String
		// Therefore the integer sum is converted to string by adding ""
		// on the response object the cookie with the name, value pair is passed to called servlet
		
		res.sendRedirect("square");
	}
}
