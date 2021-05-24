package com.example.demo.Entities;



public class Employee {

	private int id;
	private String first_name;
	private String last_name;
	private String password;
	private float salary;
	private String department;
	private String position;
	private String email_address;
	private String contact_number;
	private String picture;
	public Employee() {
	}
	public Employee(int id, String first_name, String last_name,String password, float salary, String department, String position,
			String email_address, String contact_number, String picture) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.salary = salary;
		this.department = department;
		this.position = position;
		this.email_address = email_address;
		this.contact_number = contact_number;
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", salary=" + salary
				+ ", department=" + department + ", position=" + position + ", email_address=" + email_address
				+ ", contact_number=" + contact_number + ", picture=" + picture + "]";
	}
}
