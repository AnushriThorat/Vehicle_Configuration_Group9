package com.vehiclecfg.services;

import java.util.List;
import com.vehiclecfg.entities.InvoiceDetail;

public interface InvoiceDetailServices {

    List<InvoiceDetail> getAllInvoiceDetails();

    InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail);
}