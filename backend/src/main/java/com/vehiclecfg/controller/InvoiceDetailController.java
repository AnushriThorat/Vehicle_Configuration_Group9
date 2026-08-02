package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.services.InvoiceDetailService;

@RestController
@RequestMapping("/api/invoice-details")
@CrossOrigin(origins = "http://localhost:5173")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService service;

    @PostMapping
    public InvoiceDetail save(@RequestBody InvoiceDetail invoiceDetail) {
        return service.saveInvoiceDetail(invoiceDetail);
    }

    @GetMapping
    public List<InvoiceDetail> getAll() {
        return service.getAllInvoiceDetails();
    }

    @GetMapping("/{id}")
    public InvoiceDetail getById(@PathVariable Integer id) {
        return service.getInvoiceDetailById(id);
    }

    @GetMapping("/invoice/{invoiceId}")
    public List<InvoiceDetail> getByInvoice(@PathVariable Long invoiceId) {
        return service.getInvoiceDetailsByInvoice(invoiceId);
    }

    @PutMapping("/{id}")
    public InvoiceDetail update(@PathVariable Integer id,
                                @RequestBody InvoiceDetail invoiceDetail) {

        return service.updateInvoiceDetail(id, invoiceDetail);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {

        service.deleteInvoiceDetail(id);

        return "Invoice Detail Deleted Successfully";
    }

}