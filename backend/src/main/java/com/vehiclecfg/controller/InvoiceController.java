package com.vehiclecfg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.services.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    // Create new invoice
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice inv) {
        return service.saveInvoice(inv);
    }

    // Get all invoices
    @GetMapping
    public List<Invoice> getInvoices() {
        return service.getAllInvoices();
    }

    // Get invoice by ID
    @GetMapping("/{id}")
    public Invoice getInvoice(@PathVariable Long id) {
        return service.getInvoiceById(id);
    }

    // Delete invoice
    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable Long id) {
        service.deleteInvoice(id);
    }
}
