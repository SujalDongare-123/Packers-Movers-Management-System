package com.packers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packers.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

    List<Vehicle> findByStatusIgnoreCase(String status);

}