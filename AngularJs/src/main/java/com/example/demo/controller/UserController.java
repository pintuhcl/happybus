package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "/api" })
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User userDetails = userService.addUser(user);
		return ResponseEntity.ok("User Object is saved---------::::::::" + userDetails);
	}

	@GetMapping
	public ResponseEntity<?> getAllUser() {
		List<User> userDetail = userService.listUser();
		return ResponseEntity.ok("List of User SHOWED -----::::::" + userDetail);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteUser(@PathVariable(value = "uid") Integer uid) {
		userService.deleteUser(uid);
		return ResponseEntity.ok("Deleted Object is -------::::::::" + uid);
	}

	@PutMapping
	public ResponseEntity<?> updateUser(@PathVariable(value = "uId") Integer uId, @RequestBody User user) {
		User userData = userService.updateUser(uId, user);
		return ResponseEntity.ok("Updated Object --------::::::::s" + userData);
	}

}
