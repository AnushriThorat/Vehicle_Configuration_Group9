package com.vconf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendInvoiceMail(
            String to,
            String subject,
            String body,
            byte[] pdfBytes,
            String fileName) {

        try {

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(to);

            helper.setSubject(subject);

            helper.setText(body);

            if (pdfBytes != null && pdfBytes.length > 0) {

                helper.addAttachment(
                        fileName,
                        new ByteArrayResource(pdfBytes)
                );

            }

            mailSender.send(message);

            System.out.println("MAIL SENT SUCCESSFULLY");

        }

        catch (Exception e) {

            throw new RuntimeException(
                    "Unable to send Email",
                    e
            );

        }

    }

}