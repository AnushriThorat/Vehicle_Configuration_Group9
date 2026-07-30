package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
