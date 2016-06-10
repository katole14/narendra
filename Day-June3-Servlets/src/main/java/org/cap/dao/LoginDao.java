package org.cap.dao;

import java.util.List;

import org.cap.login.pojo.Employee;
import org.cap.login.pojo.Login;

public interface LoginDao {
	public boolean isValidUser(Login login);
	
	public boolean createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(int empId);
	
	public Employee searchEmployee(int empId);
}
