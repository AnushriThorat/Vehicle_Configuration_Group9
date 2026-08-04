package com.vehiclecfg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.services.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    // ==================== CREATE ====================

    @PostMapping
    public ResponseEntity<Invoice> save(
            @RequestBody Invoice invoice) {

        Invoice savedInvoice =
                service.saveInvoice(invoice);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedInvoice);

    }

    // ==================== GET ALL ====================

    @GetMapping
    public ResponseEntity<List<Invoice>> getAll() {

        return ResponseEntity.ok(
                service.getAllInvoices()
        );

    }

    // ==================== GET BY ID ====================

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.getInvoiceById(id)
        );

    }

    // ==================== GET BY USER ====================

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Invoice>> getByUser(
            @PathVariable Integer userId) {

        return ResponseEntity.ok(
                service.getInvoicesByUser(userId)
        );

    }

    // ==================== UPDATE ====================

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> update(
            @PathVariable Long id,
            @RequestBody Invoice invoice) {

        Invoice updatedInvoice =
                service.updateInvoice(id, invoice);

        return ResponseEntity.ok(updatedInvoice);

    }

    // ==================== DELETE ====================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.deleteInvoice(id);

        return ResponseEntity.noContent().build();

    }

}