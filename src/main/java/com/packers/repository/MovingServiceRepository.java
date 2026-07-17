package com.packers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packers.entity.MovingService;

@Repository
public interface MovingServiceRepository extends JpaRepository<MovingService, Long> {

	List<MovingService> findByServiceNameContainingIgnoreCase(String serviceName);

}