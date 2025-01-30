package com.security.service;

import java.util.List;

import com.security.entity.Student;

public interface StudentService {

	Student addStudent(Student student);
	List<Student> showAllStudents();
}
