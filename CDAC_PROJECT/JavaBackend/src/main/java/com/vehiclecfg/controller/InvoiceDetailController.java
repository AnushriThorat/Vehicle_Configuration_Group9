package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.InvoiceDetail;
import com.vehiclecfg.services.InvoiceDetailService;

@RestController
@RequestMapping("/api/invoice-details")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService service;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<InvoiceDetail> save(
            @RequestBody InvoiceDetail invoiceDetail) {

        InvoiceDetail savedInvoiceDetail =
                service.saveInvoiceDetail(invoiceDetail);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedInvoiceDetail);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<InvoiceDetail>> getAll() {

        return ResponseEntity.ok(
                service.getAllInvoiceDetails()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDetail> getById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                service.getInvoiceDetailById(id)
        );

    }

    // ==================== GET BY INVOICE ====================

    @GetMapping("/invoice/{invoiceId}")
    public ResponseEntity<List<InvoiceDetail>> getByInvoice(
            @PathVariable Long invoiceId) {

        return ResponseEntity.ok(
                service.getInvoiceDetailsByInvoice(invoiceId)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDetail> update(
            @PathVariable Integer id,
            @RequestBody InvoiceDetail invoiceDetail) {

        InvoiceDetail updatedInvoiceDetail =
                service.updateInvoiceDetail(id, invoiceDetail);

        return ResponseEntity.ok(updatedInvoiceDetail);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer id) {

        service.deleteInvoiceDetail(id);

        return ResponseEntity.noContent().build();

    }

}