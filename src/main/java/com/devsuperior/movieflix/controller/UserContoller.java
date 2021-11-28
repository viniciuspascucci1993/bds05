package com.devsuperior.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.services.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/profile")
	public List<User> gatProfile() {
		return userService.findUser();
	}

}
