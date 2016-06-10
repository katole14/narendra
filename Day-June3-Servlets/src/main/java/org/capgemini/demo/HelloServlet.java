package org.capgemini.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	public void destroy() {
		System.out.println("Servlet Destroyed");
	}


	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialized");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		out.println("<h1>Welcome To Servltes</h1>");
		System.out.println("Service Invoked");
	}

}
