package org.cap.login.service;

import java.util.List;

import org.cap.dao.LoginDao;
import org.cap.dao.LoginDaoImpl;
import org.cap.login.pojo.Employee;
import org.cap.login.pojo.Login;

public class LoginServiceImpl implements LoginService{

	LoginDao loginDao=new LoginDaoImpl();
	
	public boolean isValidUser(Login login) {
		/*if(login.getUserName().equals("tom") && login.getUserPwd().equals("tom123"))
		return true;
		else
			return false;*/
		return loginDao.isValidUser(login);
	}

	public boolean createEmployee(Employee employee) {
		return loginDao.createEmployee(employee);
		
	}

	public List<Employee> getAllEmployees() {
		
		return loginDao.getAllEmployees();
	}

	public boolean deleteEmployee(int empId) {
		
		return loginDao.deleteEmployee(empId);
	}

	public Employee searchEmployee(int empId) {
		
		return loginDao.searchEmployee(empId);
	}

}
