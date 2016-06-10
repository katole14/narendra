package org.cap.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.login.pojo.Login;
import org.cap.login.service.LoginService;
import org.cap.login.service.LoginServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService loginService=new LoginServiceImpl();
		
		String uname=request.getParameter("userName");
		String uPwd=request.getParameter("userPwd");
		
		Login login=new Login();
		login.setUserName(uname);
		login.setUserPwd(uPwd);
		
		
		if(loginService.isValidUser(login))
			//response.sendRedirect("pages/employee.html");
			request.getRequestDispatcher("pages/mainPage.html").include(request, response);
		else
			response.sendRedirect("pages/Login.html");
		
		
	}

}
