package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.Vehicle;
import com.packers.repository.VehicleRepository;
import com.packers.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    // Add Vehicle
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    // Get All Vehicles
    @Override
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    // Get Vehicle By Id
    @Override
    public Vehicle getVehicleById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Not Found"));
    }

    // Update Vehicle
    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

        Vehicle existingVehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Not Found"));

        existingVehicle.setVehicleName(vehicle.getVehicleName());
        existingVehicle.setVehicleNumber(vehicle.getVehicleNumber());
        existingVehicle.setVehicleType(vehicle.getVehicleType());
        existingVehicle.setCapacity(vehicle.getCapacity());
        existingVehicle.setDriverName(vehicle.getDriverName());
        existingVehicle.setDriverMobile(vehicle.getDriverMobile());
        existingVehicle.setStatus(vehicle.getStatus());

        return repository.save(existingVehicle);
    }

    // Delete Vehicle
    @Override
    public void deleteVehicle(Long id) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle Not Found"));

        repository.delete(vehicle);
    }

    // Search Vehicle By Status
    @Override
    public List<Vehicle> getVehicleByStatus(String status) {
        return repository.findByStatusIgnoreCase(status);
    }

}