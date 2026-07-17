package com.packers.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String vehicleName;

    private String vehicleNumber;

    private String vehicleType;

    private Double capacity;

    private String driverName;

    private String driverMobile;

    private String status;
}