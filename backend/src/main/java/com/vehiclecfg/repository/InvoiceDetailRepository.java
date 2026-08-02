package com.vehiclecfg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclecfg.entities.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    List<InvoiceDetail> findByInvoiceInvId(Long invId);

}