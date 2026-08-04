package com.vehiclecfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByUserId(Integer id);

}