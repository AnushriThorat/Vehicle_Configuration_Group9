package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.Invoice;

public interface InvoiceService {

    Invoice saveInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(Long id);

    List<Invoice> getInvoicesByUser(Integer userId);

    Invoice updateInvoice(Long id, Invoice invoice);

    void deleteInvoice(Long id);

}