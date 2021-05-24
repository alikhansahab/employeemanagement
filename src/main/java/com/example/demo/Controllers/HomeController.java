package com.example.demo.Controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entities.Employee;
import com.example.demo.Services.EmployeeServices;

@Controller
public class HomeController{
	
	@Autowired
	EmployeeServices service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping("/login")
	public String login(Model model){
		//model.addAttribute("emp", new Employee());
		return "login";
	}
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String logout(Model model){
		return "login";
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("emp", new Employee());
		return "register";
	}
	
	@RequestMapping(value="/doregister", method = RequestMethod.POST)
	public String doregister(@ModelAttribute("emp") Employee emp,@RequestParam(value="confirmpassword") String confirmpassword, HttpSession session,Model model) {
		try {
			if(emp.getPassword().equals(confirmpassword)) {
				session.setAttribute("email_address", emp.getEmail_address());
				model.addAttribute("emp", new Employee());
				emp.setPassword(passwordEncoder.encode(emp.getPassword()));
				System.out.println(emp);
				service.createEmployee(emp);
				return "details";
			}
			else {
				System.out.println("Error in Email or Password...");
				return "register";
			}
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return "register";
			}
	}
	@RequestMapping("/update")
	public String update(Model model) {
		model.addAttribute("emp", new Employee());
		return "details";
	}
	@RequestMapping(value="/doupdate",method = RequestMethod.POST)
	public String doupdate(@ModelAttribute("emp") Employee emp, HttpSession session,@RequestParam("profilePicture") MultipartFile file,Model model) {
		try {
			String email = (String) session.getAttribute("email_address");
			if(file.isEmpty()) {
				System.out.println("profile is empty");
				return "details";
			}
			else {
				File filesave = new ClassPathResource("static/image/").getFile();
				Path path = Paths.get(filesave.getAbsolutePath()+File.separator+file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				service.updateEmployee(email,emp);
			    service.updatePicture(email, file.getOriginalFilename());
				return "updated";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return "details";
		}
	}
	@RequestMapping(value="/profile/{emp.email_address}",method=RequestMethod.GET)
	public String profile(@PathVariable("emp.email_address") String email,Model model,HttpSession session) {
		Employee emp = service.getEmployee(email);
		session.setAttribute("email_address", emp.getEmail_address());
		model.addAttribute("emp", emp);
		return "update";
	}
	@RequestMapping(value="/profile/updateprofile",method = RequestMethod.POST)
	public String updateprofile(@ModelAttribute("emp") Employee emp,@RequestParam("profilePicture") MultipartFile file,Model model,HttpSession session) {
		try {
			String email = (String) session.getAttribute("email_address");
			if(file.isEmpty()) {
				service.updateEmployee(email,emp);
				return "updated";
			}
			else {
				File filesave = new ClassPathResource("static/image/").getFile();
				Path path = Paths.get(filesave.getAbsolutePath()+File.separator+file.getOriginalFilename());
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				service.updateEmployee(email,emp);
				service.updatePicture(email,file.getOriginalFilename());
				return "updated";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "update";
	}
	@RequestMapping("/")
	public String home(Model model) {
		List<Employee> employees = service.getAllEmployee();
		model.addAttribute("employees", employees);
		return "home";
	}
	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping(value="/delete/{emp.email_address}",method=RequestMethod.GET)
	public String delete(@PathVariable("emp.email_address") String email,Model model) {
		service.deleteEmployee(email);
		return "deleted";
	}
	
}
