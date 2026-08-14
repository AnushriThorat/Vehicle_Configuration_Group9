package com.vconf.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vconf.dto.MailRequest;
import com.vconf.service.MailService;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = "*")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send-invoice")
    public ResponseEntity<String> sendInvoice(
            @RequestBody MailRequest request) {

        try {

            byte[] pdf = Base64.getDecoder()
                    .decode(request.getPdf());

            mailService.sendInvoiceMail(

                    request.getEmail(),

                    request.getSubject(),

                    request.getBody(),

                    pdf,

                    request.getFileName()

            );

            return ResponseEntity.ok(
                    "Mail Sent Successfully"
            );

        }

        catch (Exception e) {

            return ResponseEntity.badRequest()
                    .body(e.getMessage());

        }

    }

}