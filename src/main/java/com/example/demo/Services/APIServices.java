package com.example.demo.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dao.ConnectionProvider;
import com.example.demo.Entities.Employee;

@Service
public class APIServices {
	
	public List<Employee> getEmployeesByDepartment(String department){
		List<Employee> employees = new ArrayList<Employee>();
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee where department ='"+department+"'";
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}
	public List<Employee> getEmployeesByDepartment(String department,int start,int total){
		List<Employee> employees = new ArrayList<Employee>();
		try{
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee where department ='"+department+"' limit "+(start -1)+", "+total;
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
	try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee";
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}
	
	public List<Employee> getAllEmployees(int start,int total){
		List<Employee> employees = new ArrayList<Employee>();
	try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee  limit "+(start -1)+", "+total;
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}
	public List<Employee> getEmployeesByPosition(String position,int start,int total){
		List<Employee> employees = new ArrayList<Employee>();
	try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee where position ='"+position+"'  limit "+(start -1)+", "+total;
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}
	public List<Employee> getEmployeesByPosition(String position){
		List<Employee> employees = new ArrayList<Employee>();
	try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee where position ='"+position+"'";
			ResultSet result = st.executeQuery(sql);
			while(result.next()){
				Employee emp = new Employee();
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
				employees.add(emp);
			}
			return employees;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	return employees;
	}

}
