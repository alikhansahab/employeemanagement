package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.Entities.Employee;

public class UserDetailsServiceImple implements UserDetailsService{
	@Autowired
	private EmployeeServices service;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee = service.getLogin(email);
		if(employee==null) {
			throw new UsernameNotFoundException("User Not Found With This Email");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(employee);
		return customUserDetails;
	}

}
