package com.packers.service;

import java.util.List;

import com.packers.entity.Vehicle;

public interface VehicleService {

    Vehicle addVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getVehicleById(Long id);

    Vehicle updateVehicle(Long id, Vehicle vehicle);

    void deleteVehicle(Long id);

    List<Vehicle> getVehicleByStatus(String status);

}