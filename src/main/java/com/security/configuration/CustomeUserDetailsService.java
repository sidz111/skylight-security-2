package com.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.security.entity.Student;
import com.security.repository.StudentRepository;

@Component
public class CustomeUserDetailsService implements UserDetailsService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Student s = studentRepository.findByEmail(email);
		if(s==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		else {
			return new CustomUser(s);			
		}
	}

}
