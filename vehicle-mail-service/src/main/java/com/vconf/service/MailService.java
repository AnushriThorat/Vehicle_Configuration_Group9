package com.vconf.service;

public interface MailService {

    void sendInvoiceMail(
            String to,
            String subject,
            String body,
            byte[] pdfBytes,
            String fileName
    );

}