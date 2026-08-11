package com.vehiclecfg.services;

import java.util.List;

import com.vehiclecfg.entities.InvoiceDetail;

public interface InvoiceDetailService {

    InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail);

    List<InvoiceDetail> getAllInvoiceDetails();

    InvoiceDetail getInvoiceDetailById(Integer id);

    List<InvoiceDetail> getInvoiceDetailsByInvoice(Long invoiceId);

    InvoiceDetail updateInvoiceDetail(Integer id,
                                      InvoiceDetail invoiceDetail);

    void deleteInvoiceDetail(Integer id);

}