package com.packers.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "First Name is Required")
	private String firstName;

	private String lastName;

	@Column(unique = true, nullable = false)
	@Email(message = "Invalid Email")
	private String email;

	@NotBlank(message = "Password is Required")
	private String password;

	private String mobile;

	private LocalDate dob;

	private String nationality;

	private String address;

	private String city;

	private String state;

	private String country;

	private String role;

}
