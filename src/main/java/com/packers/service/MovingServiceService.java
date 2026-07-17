package com.packers.service;

import java.util.List;

import com.packers.entity.MovingService;

public interface MovingServiceService {

	MovingService addService(MovingService service);

	List<MovingService> getAllServices();

	MovingService getServiceById(Long id);

	MovingService updateService(Long id, MovingService service);

	void deleteService(Long id);

	List<MovingService> searchService(String serviceName);

}