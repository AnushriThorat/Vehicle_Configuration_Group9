package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.services.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "http://localhost:5173")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping
    public Invoice save(@RequestBody Invoice invoice) {
        return service.saveInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> getAll() {
        return service.getAllInvoices();
    }

    @GetMapping("/{id}")
    public Invoice getById(@PathVariable Long id) {
        return service.getInvoiceById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> getByUser(@PathVariable Integer userId) {
        return service.getInvoicesByUser(userId);
    }

    @PutMapping("/{id}")
    public Invoice update(@PathVariable Long id,
                          @RequestBody Invoice invoice) {
        return service.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.deleteInvoice(id);

        return "Invoice Deleted Successfully";
    }

}