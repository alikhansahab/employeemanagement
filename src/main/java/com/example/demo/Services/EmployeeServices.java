package com.example.demo.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dao.ConnectionProvider;
import com.example.demo.Entities.Employee;
@Service
public class EmployeeServices{
	public void createEmployee(Employee emp){
		try {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "insert into employee(first_name,last_name,email_address,password,contact_number,department,position,salary,picture) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,emp.getFirst_name());
		ps.setString(2,emp.getLast_name());
		ps.setString(3,emp.getEmail_address());
		ps.setString(4,emp.getPassword());
		ps.setString(5,emp.getContact_number());
		ps.setString(6,emp.getDepartment());
		ps.setString(7,emp.getPosition());
		ps.setFloat(8,emp.getSalary());
		ps.setString(9,emp.getPicture());
		ps.executeUpdate();
		conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public Employee getLogin(String email){
		Employee employee = new Employee();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select password from employee where email_address = '"+email+"'";
			ResultSet result = st.executeQuery(sql);
			result.next();
			String pass = result.getString("password");
			employee.setEmail_address(email);
			employee.setPassword(pass);
			return employee;
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return employee;
	}
	public Employee getEmployee(String email){
		Employee emp = new Employee();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from employee where email_address = '"+email+"'";
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
				emp.setId(result.getInt("id"));
				emp.setFirst_name(result.getString("first_name"));
				emp.setLast_name(result.getString("last_name"));
				emp.setSalary(result.getFloat("salary"));
				emp.setDepartment(result.getString("department"));
				emp.setPosition(result.getString("position"));
				emp.setEmail_address(result.getString("email_address"));
				emp.setContact_number(result.getString("contact_number"));
				emp.setPicture(result.getString("picture"));
			}
			return emp;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}
	public List<Employee> getAllEmployee(){
		List<Employee> emps = new ArrayList<Employee>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "select * from alikhan.employee";
			ResultSet result = st.executeQuery(sql);
			while(result.next()) {
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
				emps.add(emp);
			}
			return emps;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return emps;
	}
	public Employee updateEmployee(String email,Employee emp) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update employee set first_name=?,last_name=?,contact_number=?,department=?,position=?,salary=? where email_address = '"+email+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,emp.getFirst_name());
			ps.setString(2,emp.getLast_name());
			ps.setString(3,emp.getContact_number());
			ps.setString(4,emp.getDepartment());
			ps.setString(5,emp.getPosition());
			ps.setFloat(6,emp.getSalary());
			ps.executeUpdate();
			conn.close();
			return emp;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		return emp;
	}
	public void updatePicture(String email,String picture) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update employee set picture=? where email_address = '"+email+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,picture);
			ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void deleteEmployee(String email) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement st = conn.createStatement();
			String sql = "delete from alikhan.employee where email_address = '"+email+"'";
			st.executeUpdate(sql);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
