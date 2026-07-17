package com.packers.service;

import java.util.List;

import com.packers.entity.Quotation;

public interface QuotationService {

    Quotation createQuotation(Quotation quotation);

    List<Quotation> getAllQuotations();

    Quotation getQuotationById(Long id);

    Quotation updateQuotation(Long id, Quotation quotation);

    void deleteQuotation(Long id);

    List<Quotation> getQuotationByStatus(String status);

}