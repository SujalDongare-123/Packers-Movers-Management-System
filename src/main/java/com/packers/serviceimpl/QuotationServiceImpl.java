package com.packers.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.packers.entity.Quotation;
import com.packers.repository.QuotationRepository;
import com.packers.service.QuotationService;

@Service
public class QuotationServiceImpl implements QuotationService {

    private final QuotationRepository repository;

    public QuotationServiceImpl(QuotationRepository repository) {
        this.repository = repository;
    }

    // Create Quotation
    @Override
    public Quotation createQuotation(Quotation quotation) {
        return repository.save(quotation);
    }

    // Get All Quotations
    @Override
    public List<Quotation> getAllQuotations() {
        return repository.findAll();
    }

    // Get Quotation By Id
    @Override
    public Quotation getQuotationById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation Not Found"));

    }

    // Update Quotation
    @Override
    public Quotation updateQuotation(Long id, Quotation quotation) {

        Quotation existingQuotation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation Not Found"));

        existingQuotation.setUser(quotation.getUser());
        existingQuotation.setMovingService(quotation.getMovingService());
        existingQuotation.setFromAddress(quotation.getFromAddress());
        existingQuotation.setToAddress(quotation.getToAddress());
        existingQuotation.setShiftingDate(quotation.getShiftingDate());
        existingQuotation.setReference(quotation.getReference());
        existingQuotation.setServiceDetails(quotation.getServiceDetails());
        existingQuotation.setStatus(quotation.getStatus());

        return repository.save(existingQuotation);
    }

    // Delete Quotation
    @Override
    public void deleteQuotation(Long id) {

        Quotation quotation = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quotation Not Found"));

        repository.delete(quotation);
    }

    // Search By Status
    @Override
    public List<Quotation> getQuotationByStatus(String status) {

        return repository.findByStatus(status);

    }

}