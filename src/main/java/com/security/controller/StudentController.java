package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.entity.Student;
import com.security.repository.StudentRepository;
import com.security.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String homepage(Model model) {
		model.addAttribute("students", studentService.showAllStudents());
		String student_email = SecurityContextHolder.getContext().getAuthentication().getName();
		Student s = studentRepository.findByEmail(student_email);
		model.addAttribute("student", s);
		return "index";
	}
	
	@GetMapping("/user")
	public String userpage() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String adminpage() {
		return "admin";
	}
	
	@GetMapping("/signin")
	public String loginPage() {
		return "signin";
	}
	
	@GetMapping("/invalid")
	public String getInvalidPage() {
		return "error-page";
	}
	
	@PostMapping("/add-student")
	public String addStudent(@ModelAttribute Student student) {
		student.setRole("ROLE_USER");
		System.out.println("Before Encode: "+student.getPassword());
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		System.out.println("After encode: "+student.getPassword());
		studentService.addStudent(student);		
		return "redirect:/";
	}
}
