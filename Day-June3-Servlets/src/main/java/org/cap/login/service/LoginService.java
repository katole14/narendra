package org.cap.login.service;

import java.util.List;

import org.cap.login.pojo.Employee;
import org.cap.login.pojo.Login;

public interface LoginService {
	
	public boolean isValidUser(Login login);
	public boolean createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int empId);
	public Employee searchEmployee(int empId);
}
