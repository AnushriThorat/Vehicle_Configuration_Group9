package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.repository.InvoiceDetailRepository;
import com.vehiclecfg.services.InvoiceDetailServices;

@Service
public class InvoiceDetailsServicesImpl implements InvoiceDetailServices {

    @Autowired
    private InvoiceDetailRepository repository;

    @Override
    public List<InvoiceDetail> getAllInvoiceDetails() {
        return repository.findAll();
    }

    @Override
    public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        return repository.save(invoiceDetail);
    }
}