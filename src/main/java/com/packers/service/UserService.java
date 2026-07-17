package com.packers.service;

import java.util.List;

import com.packers.entity.User;

public interface UserService {

	User registerUser(User user);

	User loginUser(String email, String password);

	List<User> getAllUsers();

	User getUserById(Long id);

	User updateUser(Long id, User user);

	void deleteUser(Long id);

}
