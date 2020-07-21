package br.com.massenan.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.massenan.entity.User;
import br.com.massenan.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	@Transactional
	public String getRegister(@RequestBody User user) {
		service.saveUser(user);
		return "Hello! Welcome. Your username is: " + user.getUsername();
	}

	@GetMapping("/allUser")
	public Iterable<User> findAllUser(){
		return service.getAllUser();
	}
	
	@GetMapping("/byUsername/{username}")
	@Transactional
	public User getByUsername(@PathVariable String username) {
		return service.findUser(username);
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username){
		service.deleteUser(username);
		return service.getAllUser();
	}
}
