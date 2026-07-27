package com.vehiclecfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

}
