package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.exception.InvoiceDetailNotFoundException;
import com.vehiclecfg.repository.InvoiceDetailRepository;
import com.vehiclecfg.services.InvoiceDetailService;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository repository;

    @Override
    public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) {

        return repository.save(invoiceDetail);

    }

    @Override
    public List<InvoiceDetail> getAllInvoiceDetails() {

        return repository.findAll();

    }

    @Override
    public InvoiceDetail getInvoiceDetailById(Integer id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Invoice Detail not found with ID : " + id

                        )

                );

    }

    @Override
    public List<InvoiceDetail> getInvoiceDetailsByInvoice(Long invoiceId) {

        return repository.findByInvoiceInvId(invoiceId);

    }

    @Override
    public InvoiceDetail updateInvoiceDetail(
            Integer id,
            InvoiceDetail invoiceDetail) {

        InvoiceDetail existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Invoice Detail not found with ID : " + id

                        )

                );

        existing.setInvoice(invoiceDetail.getInvoice());

        existing.setComponent(invoiceDetail.getComponent());

        existing.setAlternateComponent(invoiceDetail.getAlternateComponent());

        existing.setDeltaPrice(invoiceDetail.getDeltaPrice());

        existing.setModel(invoiceDetail.getModel());

        return repository.save(existing);

    }

    @Override
    public void deleteInvoiceDetail(Integer id) {

        InvoiceDetail existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceDetailNotFoundException(

                                "Invoice Detail not found with ID : " + id

                        )

                );

        repository.delete(existing);

    }

}