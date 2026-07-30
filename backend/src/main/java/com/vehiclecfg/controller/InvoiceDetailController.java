package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.services.InvoiceDetailServices;

@RestController
@RequestMapping("/invoicedetail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailServices service;

    @PostMapping
    public InvoiceDetail save(@RequestBody InvoiceDetail obj) {
        return service.saveInvoiceDetail(obj);
    }

    @GetMapping
    public List<InvoiceDetail> getAll() {
        return service.getAllInvoiceDetails();
    }
}