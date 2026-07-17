package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.User;
import com.packers.repository.UserRepository;
import com.packers.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User registerUser(User user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new RuntimeException("Email already registered.");
		}

		return userRepository.save(user);
	}

	@Override
	public User loginUser(String email, String password) {

		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("Invalid Password");
		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public User updateUser(Long id, User user) {

		User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setMobile(user.getMobile());
		existingUser.setDob(user.getDob());
		existingUser.setNationality(user.getNationality());
		existingUser.setAddress(user.getAddress());
		existingUser.setCity(user.getCity());
		existingUser.setState(user.getState());
		existingUser.setCountry(user.getCountry());
		existingUser.setRole(user.getRole());

		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {

		User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

		userRepository.delete(user);
	}

}