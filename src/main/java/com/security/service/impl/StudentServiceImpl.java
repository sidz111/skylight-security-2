package com.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.Student;
import com.security.repository.StudentRepository;
import com.security.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public List<Student> showAllStudents() {
		return this.studentRepository.findAll();
	}

}
