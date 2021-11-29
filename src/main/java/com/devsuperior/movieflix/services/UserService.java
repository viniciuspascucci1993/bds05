package com.devsuperior.movieflix.services;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.security.AuthorizationService;

@Service
public class UserService implements UserDetailsService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
    private AuthorizationService authService;
	
    @Transactional(readOnly = true)
    public UserDTO getProfile() {
        return new UserDTO(authService.authenticated());
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			logger.error("User Not Found: {}" , username);
			throw new UsernameNotFoundException("E-mail not found");
		}
		
		logger.info("User Found: {}" , username);
		return user;
	}
	

}
