package org.cap.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.login.service.LoginService;
import org.cap.login.service.LoginServiceImpl;


public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService loginService=new LoginServiceImpl();
		
	String eid=request.getParameter("employeeId");
	
	int empId=Integer.parseInt(eid);
	
	boolean flag=loginService.deleteEmployee(empId);
	
	if(flag)
		request.getRequestDispatcher("ListAllEmpServlet").forward(request, response);
	else
		request.getRequestDispatcher("pages/errorPage.html").forward(request, response);
	
	}

}
