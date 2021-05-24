package com.example.demo.Controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Employee;
import com.example.demo.Services.APIServices;

@RestController
public class APIController {
	@Autowired
	APIServices service;
	
	@GetMapping("/filter/all")
	public List<Employee> filterAll(){
		return service.getAllEmployees();
	}
	@GetMapping("/filter/all/{start}/{total}")
	public List<Employee> filterRange(@PathVariable("start") int start,@PathVariable("total") int total){
		return service.getAllEmployees(start,total);
	}
	@PostMapping("/filter/department/{start}/{total}")
	public List<Employee> filterDepartment(@RequestBody String filter,@PathVariable("start") int start,@PathVariable("total") int total){
		return  service.getEmployeesByDepartment(filter,start,total);
	}
	@PostMapping("/filter/position/{start}/{total}")
	public List<Employee> filterPosition(@RequestBody String filter,@PathVariable("start") int start,@PathVariable("total") int total){
		List <Employee> employees = service.getEmployeesByPosition(filter,start,total);
		return  employees;
	}
}
