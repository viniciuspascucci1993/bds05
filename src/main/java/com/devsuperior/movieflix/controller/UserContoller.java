package com.devsuperior.movieflix.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<UserDTO> gatProfile() {
		UserDTO dto = userService.getProfile();  
		return ResponseEntity.ok(dto);
	}

}
