package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.MovingService;
import com.packers.repository.MovingServiceRepository;
import com.packers.service.MovingServiceService;

@Service
public class MovingServiceServiceImpl implements MovingServiceService {

    private final MovingServiceRepository repository;

    public MovingServiceServiceImpl(MovingServiceRepository repository) {
        this.repository = repository;
    }

    // Add New Service
    @Override
    public MovingService addService(MovingService service) {
        return repository.save(service);
    }

    // Get All Services
    @Override
    public List<MovingService> getAllServices() {
        return repository.findAll();
    }

    // Get Service By Id
    @Override
    public MovingService getServiceById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Not Found"));

    }

    // Update Existing Service
    @Override
    public MovingService updateService(Long id, MovingService service) {

        // Find the service by id
        MovingService existingService = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Not Found"));

        // Update all fields
        existingService.setServiceName(service.getServiceName());
        existingService.setDescription(service.getDescription());
        existingService.setImage(service.getImage());
        existingService.setStatus(service.getStatus());
        existingService.setPrice(service.getPrice());

        // Save updated service
        return repository.save(existingService);
    }

    // Delete Service
    @Override
    public void deleteService(Long id) {

        MovingService service = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service Not Found"));

        repository.delete(service);
    }

    // Search Service By Name
    @Override
    public List<MovingService> searchService(String serviceName) {

        return repository.findByServiceNameContainingIgnoreCase(serviceName);
    }

}