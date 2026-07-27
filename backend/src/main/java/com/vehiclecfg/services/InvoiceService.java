package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Invoice;

public interface InvoiceService {
    Invoice saveInvoice(Invoice inv);
    List<Invoice> getAllInvoices();
    Invoice getInvoiceById(Long id);
    void deleteInvoice(Long id);
}
