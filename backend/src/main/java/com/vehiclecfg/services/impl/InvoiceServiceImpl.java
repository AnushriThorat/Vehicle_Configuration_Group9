package com.vehiclecfg.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.repository.InvoiceRepository;
import com.vehiclecfg.services.InvoiceService;

import java.util.List;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repo;

    @Override
    public Invoice saveInvoice(Invoice inv) {
        // Calculate tax = 12% of (vehicle amount + component amount)
        double baseAmount = inv.getTotalAmt() + inv.getComponentAmt();
        double tax = baseAmount * 0.12;
        inv.setTax(tax);

        // Calculate net amount
        inv.setNetAmt(baseAmount + tax);

        return repo.save(inv);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repo.findAll();
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteInvoice(Long id) {
        repo.deleteById(id);
    }

	
}
