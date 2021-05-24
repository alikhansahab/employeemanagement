package com.example.demo.Services;

import java.util.Collection;
//import java.util.List;

import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Entities.Employee;

public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee;
	public CustomUserDetails(Employee employee) {
		super();
		this.employee = employee;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//SimpleGrantedAuthority impleGrantedAuthority=new SimpleGrantedAuthority(employee.getRole());
		//return List.of(impleGrantedAuthority);
		return null;
	}

	@Override
	public String getPassword(){
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		return employee.getEmail_address();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
