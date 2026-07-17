package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.Vehicle;
import com.packers.service.VehicleService;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	private final VehicleService service;

	public VehicleController(VehicleService service) {
		this.service = service;
	}

	// Add Vehicle
	@PostMapping
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {

		return new ResponseEntity<>(service.addVehicle(vehicle), HttpStatus.CREATED);
	}

	// Get All Vehicles
	@GetMapping
	public ResponseEntity<List<Vehicle>> getAllVehicles() {

		return ResponseEntity.ok(service.getAllVehicles());
	}

	// Get Vehicle By Id
	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getVehicleById(id));
	}

	// Update Vehicle
	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {

		return ResponseEntity.ok(service.updateVehicle(id, vehicle));
	}

	// Delete Vehicle
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {

		service.deleteVehicle(id);

		return ResponseEntity.ok("Vehicle Deleted Successfully");
	}

	// Search Vehicle By Status
	@GetMapping("/status")
	public ResponseEntity<List<Vehicle>> getVehicleByStatus(@RequestParam String status) {

		return ResponseEntity.ok(service.getVehicleByStatus(status));
	}

}