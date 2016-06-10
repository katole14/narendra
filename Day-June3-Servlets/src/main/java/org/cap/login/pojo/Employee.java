package org.cap.login.pojo;

import java.util.Date;

public class Employee {
	
	private int empId;
	private String firstName;
	private String lastName;
	private double salary;
	private Date empDoj;
	private Date empDob;
	private Department department;
	private String address;
	private String email;
	private String gender;
	private String qualification;
	
	public Employee(){}
	
	public Employee(int empId, String firstName, String lastName, double salary, Date empDoj, Date empDob,
			Department department, String address, String email, String gender, String qualification) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.empDoj = empDoj;
		this.empDob = empDob;
		this.department = department;
		this.address = address;
		this.email = email;
		this.gender = gender;
		this.qualification = qualification;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getEmpDoj() {
		return empDoj;
	}
	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", empDoj=" + empDoj + ", empDob=" + empDob + ", department=" + department + ", address=" + address
				+ ", email=" + email + ", gender=" + gender + ", qualification=" + qualification + "]";
	}
	
	
	

}
