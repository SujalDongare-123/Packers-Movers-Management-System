package com.packers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packers.entity.Quotation;


@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long>{

    List<Quotation> findByStatus(String status);

}