package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.User;
import com.packers.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {

		User savedUser = userService.registerUser(user);

		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {

		userService.loginUser(user.getEmail(), user.getPassword());

		return ResponseEntity.ok("Login Successful");
	}

	// getAlluser

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = userService.getAllUsers();

		return ResponseEntity.ok(users);
	}

	// getById

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {

		User user = userService.getUserById(id);

		return ResponseEntity.ok(user);
	}

	// Update the user

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {

		User updatedUser = userService.updateUser(id, user);

		return ResponseEntity.ok(updatedUser);
	}
	
	
	//delete 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {

	    userService.deleteUser(id);

	    return ResponseEntity.ok("User Deleted Successfully");
	}
	

}