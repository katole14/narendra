package org.cap.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.login.pojo.Employee;
import org.cap.login.service.LoginService;
import org.cap.login.service.LoginServiceImpl;


public class ListAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		LoginService loginService=new LoginServiceImpl();
		List<Employee> employees=loginService.getAllEmployees();
		
		SimpleDateFormat myFormat=new SimpleDateFormat("dd-MMM-yyyy");
		
		PrintWriter out=response.getWriter();
		
		out.println("<html><head><title>List All Employees</title></head><body>"
				+ "<h1 align='center'>List Of Employees</h1>"
				+ "<table>"
				+ "<tr>"
				+ "<th>EmpId</th>"
				+ "<th>FirstName</th>"
				+ "<th>LAstNAme</th>"
				+ "<th>Salary</th>"
				
				+ "<th>Gender</th>"
				+ "<th>Qulification</th>"
				+ "<th>DateOfBirth</th>"
				+ "<th>DateOf joining</th>"
				+ "<th>Edit</th>"
				+ "</tr>");
		for(Employee emp:employees){
			out.println("<tr>"
					+ "<td>"+emp.getEmpId()+"</td>"
							+ "<td>"+emp.getFirstName()+"</td>"
									+ "<td>"+emp.getLastName()+"</td>"
											+ "<td>"+emp.getSalary()+"</td>"
													
													
+ "<td>"+emp.getGender()+"</td>"
		+ "<td>"+emp.getQualification()+"</td>");
			
			if(emp.getEmpDob()!=null)
				out.println("<td>"+myFormat.format(emp.getEmpDob())+"</td>");
			else
				out.println("<td>  </td>");
		
			if(emp.getEmpDoj()!=null)	
				out.println("<td>"+myFormat.format(emp.getEmpDoj())+"</td>");									
			else
				out.println("<td>  </td>");		
					
					
						out.println("<td>"
								+ "<a href='DeleteEmpServlet?employeeId="+ emp.getEmpId() +"'> Delete </a><br>"
										+ "<a href='UpdateEmpServlet?employeeId="+ emp.getEmpId() +"'> Update </a>"
										+ "</td>"
								+ "</tr>");
			
			
		}
		
		
		
		out.println("</table><body></html>");
	
	}

}
