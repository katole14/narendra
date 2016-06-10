package org.cap.login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.login.pojo.Department;
import org.cap.login.pojo.Employee;
import org.cap.login.service.LoginService;
import org.cap.login.service.LoginServiceImpl;


public class SaveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService loginService=new LoginServiceImpl();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String salary=request.getParameter("empSalary");
		
		String empDob=request.getParameter("empDob");
		String empDoj=request.getParameter("empDoj");
		String[] qualification=request.getParameterValues("chkQualification");
		String qalify="";
		for(String str:qualification)
			qalify+=str+",";
		
		String gender=request.getParameter("gender");
		
		String empDepart=request.getParameter("empDepart");
		String empAddress=request.getParameter("empAddress");
		
		Employee employee=new Employee();
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setEmail(email);
		employee.setSalary(Double.parseDouble(salary));
		
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date eDoj=null;
		Date eDob=null;
		try {
			eDoj=myFormat.parse(empDoj);
			eDob=myFormat.parse(empDob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employee.setEmpDob(eDob);//dd-MMM-yyyy
		employee.setEmpDoj(eDoj);//dd-MMM-yyyy
		employee.setQualification(qalify);
		employee.setGender(gender);
		employee.setAddress(empAddress);
		Department department=new Department();
		department.setDepartmentId(Integer.parseInt(empDepart));
		employee.setDepartment(department);
		
		boolean flag=loginService.createEmployee(employee);
		if(flag)
			response.sendRedirect("pages/employee.html");
		else
			response.sendRedirect("pages/errorPage.html");
		
	}

}
