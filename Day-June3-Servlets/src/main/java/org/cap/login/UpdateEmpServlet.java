package org.cap.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.login.pojo.Employee;
import org.cap.login.service.LoginService;
import org.cap.login.service.LoginServiceImpl;

/**
 * Servlet implementation class UpdateEmpServlet
 */
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		int empId=Integer.parseInt(request.getParameter("employeeId"));
		
		LoginService loginService=new LoginServiceImpl();
		Employee emp=loginService.searchEmployee(empId);
		
		String qualifications=emp.getQualification();
		String[] qualificationsArray=qualifications.split(",");
		List<String> qualificationsList=new ArrayList<>();
		
		for(String q:qualificationsArray)
			qualificationsList.add(q);
		
		out.println("<html><head><title>UpdateEmployee</title></head>"
				+ "<body>"
				+ "<form method='post' action='#' >");
		
		out.println("<h1 align='center'>Update Emplyee</h1><hr>");	
		
		
		out.println("<table style='margin-left:200px;border:1px solid black;'>"
				+ "<tr>"
				+ "<td>Employee Id</td>"
				+ "<td>"+emp.getEmpId()+"</td>" 
				+ "</tr>"
				+ "<tr>"
				+ "<td>FirstName</td>"
				+ "<td><input type='text' name='fname' value='" + emp.getFirstName()+"' size='20'>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>LastName</td>"
				+ "<td><input type='text' name='lname' value='"+emp.getLastName()+"' size='20'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td> Email</td>"
				+ "<td><input type='text' name='email' value='"+emp.getEmail()+"' size='20'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Employee salary</td>"
				+ "<td><input type='text' name='empSalary' value='"+emp.getSalary()+"' size='20'></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Date of Birth</td>"
				+ "<td><input type='Date' name='empDob' value='"+emp.getEmpDob()+"' pattern=''></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<tr>"
				+ "<td>Date of joining</td>"
				+ "<td><input type='Date' name='empDob' value='"+emp.getEmpDoj()+"' pattern=''></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Qualification</td>");
				if(qualificationsList.contains("BE"))
					out.println("<td><input type='checkbox' checked='checked' name='chkQualification' value='"+emp.getQualification()+"'>BE");
				else
					out.println("<td><input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>BE");
				if(qualificationsList.contains("ME"))
					out.println("<input type='checkbox' checked='checked' name='chkQualification' value='"+emp.getQualification()+"'>ME");
				else
					out.println("<input type='checkbox'  name='chkQualification' value='"+emp.getQualification()+"'>ME");
				if(qualificationsList.contains("MBA"))
					out.println("<input type='checkbox' checked='checked' name='chkQualification' value='"+emp.getQualification()+"'>MBA");
				else
					out.println("<input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>MBA");
				if(qualificationsList.contains("BTECH"))
					out.println( "<input type='checkbox'checked='checked' name='chkQualification' value='"+emp.getQualification()+"'>BTECH");
				else
					out.println( "<input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>BTECH");
					/*out.println(  "<td><input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>BE"
						+ "<input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>ME"
								+ "<input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>MBA"
										+ "<input type='checkbox' name='chkQualification' value='"+emp.getQualification()+"'>BTECH"*/
				out.println(  "</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td> Gender</td>"
				+ "<td><input type='radio' name='gender' value='"+emp.getGender()+"'>Male"
						+ "<input type='radio' name='gender' value='"+emp.getGender()+"'>Female"
				+ "</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Department</td>"
				+ "<td><select name='empDepart'>"
				+ "<option value='"+emp.getDepartment().getDepartmentName()+"'>Sales</option>"
				+ "<option value='"+emp.getDepartment().getDepartmentName()+"'>Purchase</option>"
				+ "<option value='"+emp.getDepartment().getDepartmentName()+"'>Finance</option>"
				+ "<option value='"+emp.getDepartment().getDepartmentName()+"'>Marketing</option>"
				+ "</td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td>Address</td>"
				+ "<td> <textarea rows='5' cols='20' name='empAddress'>"+emp.getAddress()+"</textarea></td>"
				+ "</tr>"
				+ "<tr>"
				+ "<td></td>"
				+ "<td><input type='submit' name='update' value='Update'>"
				+ "</tr>");
		
		
				
				
				out.println( "</table></form></body></html>");
		
		
		
		
	
	}

}
