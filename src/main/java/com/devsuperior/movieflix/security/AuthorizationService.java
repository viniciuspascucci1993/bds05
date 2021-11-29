package com.devsuperior.movieflix.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.security.exceptions.UnAuthorizedException;

@Service
public class AuthorizationService {
	
	@Autowired    
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName(); 
			return userRepository.findByEmail(username);  
			
		} catch (Exception e) {
			 throw new UnAuthorizedException("Invalid user"); 
		}
    }
}
