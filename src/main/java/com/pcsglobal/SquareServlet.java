// SquareServlet is called by AddSqReqDispatcher servlet for processing the square of the numbers sent by it by Request object
// SquareServlet is called by AddSqsendRedirect servlet for processing the square of the numbers sent by it by Response object


package com.pcsglobal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SquareServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		// Data send by sendRedirect needs to be captured using request get parameter (* req.getAttribute is wrong)
		// RequestDispatcher or sendRedirect::
		/*
		 * int sum = Integer.parseInt(req.getParameter("sum"));
		 */
		
		// Session:: we have to process the request data passed by the session
		/*
		HttpSession session = req.getSession();   // get hold of the session object
		int sum = (int) session.getAttribute("sum");   // we are converting the object to int by typecasting 
		*/
		
		// Cookie:: we have to process the request data passed by the cookie
		int sum = 0;
		Cookie cookies[] = req.getCookies(); 
		
		for (Cookie c : cookies)
		{
			if (c.getName().equals("sum"))
				sum = Integer.parseInt(c.getValue());
		}
		
		/*
		* Accept the cookie. It is getCookies because there can be lot many cookies sent by client request
		* It is a request object because the technique is sendRedirect servlet call which sends the response
		* to the client and the client requests the calling servlet with the Cookie data
		* Application server gives all the Cookies it has and it is now the servlet that needs to pick up the desired cookie 
		* enhanced for loop iterates through the cookies array 
		*/
		
		
		// Square the number
		sum = sum * sum;
		
		PrintWriter out = res.getWriter();
		out.println("Square is: " +sum);
		
		// to remove the data from the session
		/* 
		 * session.removeAttribute("sum");
		 */
	}
}