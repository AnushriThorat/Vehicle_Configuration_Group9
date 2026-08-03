package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.exception.InvoiceNotFoundException;
import com.vehiclecfg.repository.InvoiceRepository;
import com.vehiclecfg.services.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {

        double tax = invoice.getTotalAmt() * 0.12;

        invoice.setTax(tax);

        invoice.setNetAmt(invoice.getTotalAmt() + tax);

        return repository.save(invoice);

    }

    @Override
    public List<Invoice> getAllInvoices() {

        return repository.findAll();

    }

    @Override
    public Invoice getInvoiceById(Long id) {

        return repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceNotFoundException(

                                "Invoice not found with ID : " + id

                        )

                );

    }

    @Override
    public List<Invoice> getInvoicesByUser(Integer userId) {

        return repository.findByUserId(userId);

    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {

        Invoice existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceNotFoundException(

                                "Invoice not found with ID : " + id

                        )

                );

        existing.setInvDate(invoice.getInvDate());

        existing.setUser(invoice.getUser());

        existing.setModel(invoice.getModel());

        existing.setTotalAmt(invoice.getTotalAmt());

        double tax = invoice.getTotalAmt() * 0.12;

        existing.setTax(tax);

        existing.setNetAmt(invoice.getTotalAmt() + tax);

        return repository.save(existing);

    }

    @Override
    public void deleteInvoice(Long id) {

        Invoice existing = repository.findById(id)

                .orElseThrow(() ->

                        new InvoiceNotFoundException(

                                "Invoice not found with ID : " + id

                        )

                );
        repository.delete(existing);

    }

}