package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cap.login.pojo.Department;
import org.cap.login.pojo.Employee;
import org.cap.login.pojo.Login;

public class LoginDaoImpl implements LoginDao {

	public boolean isValidUser(Login login) {
		
		boolean flag=false;
		String sql="select * from userlogin where username=? and userpwd=?";
		try {
			PreparedStatement pst=getSQLConnection().prepareStatement(sql);
			
			pst.setString(1, login.getUserName());
			pst.setString(2, login.getUserPwd());
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	
	public Connection getSQLConnection(){
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/capdb","root","India123");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}


	@SuppressWarnings("finally")
	public boolean createEmployee(Employee employee) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="insert into employee1(firstname,lastname,salary,departId,emailId,empDob,empDoj,qualification,gender,address) "
												+ "values (?,?,?,?,?,?,?,?,?,?) ";
		try {
			conn=getSQLConnection();
			pst=conn.prepareStatement(sql);
			
			
			pst.setString(1, employee.getFirstName());
			pst.setString(2, employee.getLastName());
			pst.setDouble(3, employee.getSalary());
			pst.setInt(4, employee.getDepartment().getDepartmentId());
			pst.setString(5, employee.getEmail());
			
			
			pst.setDate(6, new Date(employee.getEmpDob().getTime()));
			pst.setDate(7, new Date(employee.getEmpDoj().getTime()));
			pst.setString(8, employee.getQualification());
			pst.setString(9, employee.getGender());
			pst.setString(10, employee.getAddress());
			
			
			int count=pst.executeUpdate();
			
			if(count>0){
				flag=true;
				System.out.println("Record Inserted");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
			try {
				
				pst.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return flag;
		}
		
	}


	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pst=null;
		
		String sql="select * from employee1";
		
		try{
		conn=getSQLConnection();
		pst=conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()){
			Employee emp=new Employee();
			
			emp.setEmpId(rs.getInt(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			Department depart=new Department();
			depart.setDepartmentId(rs.getInt(5));
			emp.setDepartment(depart);
			
			emp.setEmail(rs.getString(6));
			emp.setEmpDob(rs.getDate(7));
			emp.setEmpDoj(rs.getDate(8));
			emp.setQualification(rs.getString(9));
			emp.setGender(rs.getString(10));
			emp.setAddress(rs.getString(11));
			
			employees.add(emp);
			
		}
		
	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return employees;
	}


	@SuppressWarnings("finally")
	public boolean deleteEmployee(int empId) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pst=null;
		
		String sql="delete from employee1 where empid=?";
		
		try{
			
			conn=getSQLConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, empId);
			
			int count=pst.executeUpdate();
			
			if(count>0)
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		
		//return flag;
	}


	public Employee searchEmployee(int empId) {
		Employee emp=new Employee();
		
		Connection conn=null;
		PreparedStatement pst=null;
		
		String sql="select * from employee1 where empid=?";
		
		try{
		conn=getSQLConnection();
		pst=conn.prepareStatement(sql);
		
		pst.setInt(1, empId);
		
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			emp.setEmpId(rs.getInt(1));
			emp.setFirstName(rs.getString(2));
			emp.setLastName(rs.getString(3));
			emp.setSalary(rs.getDouble(4));
			Department depart=new Department();
			depart.setDepartmentId(rs.getInt(5));
			emp.setDepartment(depart);
			
			emp.setEmail(rs.getString(6));
			emp.setEmpDob(rs.getDate(7));
			emp.setEmpDoj(rs.getDate(8));
			emp.setQualification(rs.getString(9));
			emp.setGender(rs.getString(10));
			emp.setAddress(rs.getString(11));
			
		}else
			emp=null;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return emp;
	}
	
}
