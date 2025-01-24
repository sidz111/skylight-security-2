package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Student findByEmail(String email);
}
