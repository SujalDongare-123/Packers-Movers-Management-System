package com.packers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.packers.entity.Quotation;
import com.packers.service.QuotationService;

@RestController
@RequestMapping("/api/quotations")
public class QuotationController {

    private final QuotationService service;

    public QuotationController(QuotationService service) {
        this.service = service;
    }

    // Create Quotation
    @PostMapping
    public ResponseEntity<Quotation> createQuotation(@RequestBody Quotation quotation) {

        Quotation savedQuotation = service.createQuotation(quotation);

        return new ResponseEntity<>(savedQuotation, HttpStatus.CREATED);
    }

    // Get All Quotations
    @GetMapping
    public ResponseEntity<List<Quotation>> getAllQuotations() {

        List<Quotation> quotations = service.getAllQuotations();

        return ResponseEntity.ok(quotations);
    }

    // Get Quotation By Id
    @GetMapping("/{id}")
    public ResponseEntity<Quotation> getQuotationById(@PathVariable Long id) {

        Quotation quotation = service.getQuotationById(id);

        return ResponseEntity.ok(quotation);
    }

    // Update Quotation
    @PutMapping("/{id}")
    public ResponseEntity<Quotation> updateQuotation(@PathVariable Long id,
                                                     @RequestBody Quotation quotation) {

        Quotation updatedQuotation = service.updateQuotation(id, quotation);

        return ResponseEntity.ok(updatedQuotation);
    }

    // Delete Quotation
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuotation(@PathVariable Long id) {

        service.deleteQuotation(id);

        return ResponseEntity.ok("Quotation Deleted Successfully");
    }

    // Search Quotation By Status
    @GetMapping("/status")
    public ResponseEntity<List<Quotation>> getQuotationByStatus(
            @RequestParam String status) {

        List<Quotation> quotations = service.getQuotationByStatus(status);

        return ResponseEntity.ok(quotations);
    }

}