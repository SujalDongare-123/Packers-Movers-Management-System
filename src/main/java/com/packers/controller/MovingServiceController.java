package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.MovingService;
import com.packers.service.MovingServiceService;

@RestController
@RequestMapping("/api/services")
public class MovingServiceController {

	private final MovingServiceService service;

	public MovingServiceController(MovingServiceService service) {
		this.service = service;
	}

	// Add New Service
	@PostMapping
	public ResponseEntity<MovingService> addService(@RequestBody MovingService movingService) {

		MovingService savedService = service.addService(movingService);

		return new ResponseEntity<>(savedService, HttpStatus.CREATED);
	}

	// Get All Services
	@GetMapping
	public ResponseEntity<List<MovingService>> getAllServices() {

		List<MovingService> services = service.getAllServices();

		return ResponseEntity.ok(services);
	}

	// Get Service By Id
	@GetMapping("/{id}")
	public ResponseEntity<MovingService> getServiceById(@PathVariable Long id) {

		MovingService movingService = service.getServiceById(id);

		return ResponseEntity.ok(movingService);
	}

	// Update Service
	@PutMapping("/{id}")
	public ResponseEntity<MovingService> updateService(@PathVariable Long id,
			@RequestBody MovingService movingService) {

		MovingService updatedService = service.updateService(id, movingService);

		return ResponseEntity.ok(updatedService);
	}

	// Delete Service
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteService(@PathVariable Long id) {

		service.deleteService(id);

		return ResponseEntity.ok("Service Deleted Successfully");
	}

	// Search Service
	@GetMapping("/search")
	public ResponseEntity<List<MovingService>> searchService(@RequestParam String serviceName) {

		List<MovingService> services = service.searchService(serviceName);

		return ResponseEntity.ok(services);
	}

}