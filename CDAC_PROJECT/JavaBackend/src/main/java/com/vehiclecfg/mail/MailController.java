package com.vehiclecfg.mail;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.vehiclecfg.dto.MailRequest;

@RestController
@RequestMapping("/api/mail")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "http://localhost:3000"
})
public class MailController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mail.service.url}")
    private String mailServiceUrl;


    // =========================================================
    // SEND INVOICE MAIL
    // =========================================================

    @PostMapping("/send-invoice")
    public ResponseEntity<String> sendInvoice(

            @RequestParam("email")
            String email,

            @RequestParam("invoiceNo")
            String invoiceNo,

            @RequestParam("pdf")
            MultipartFile pdf

    ) {

        try {

            // -------------------------------------------------
            // Validation
            // -------------------------------------------------

            if (email == null || email.isBlank()) {

                return ResponseEntity
                        .badRequest()
                        .body("Email is required.");
            }


            if (invoiceNo == null || invoiceNo.isBlank()) {

                return ResponseEntity
                        .badRequest()
                        .body("Invoice number is required.");
            }


            if (pdf == null || pdf.isEmpty()) {

                return ResponseEntity
                        .badRequest()
                        .body("Invoice PDF is required.");
            }


            // -------------------------------------------------
            // Create Mail Request
            // -------------------------------------------------

            MailRequest request =
                    new MailRequest();


            request.setEmail(email);


            request.setSubject(
                    "Order Confirmation - "
                    + invoiceNo
            );


            request.setBody(
                    "Dear Customer,\n\n"
                    + "Please find your invoice attached.\n\n"
                    + "Thank you for choosing 9 Wheels."
            );


            String fileName =
                    pdf.getOriginalFilename();


            if (fileName == null ||
                fileName.isBlank()) {

                fileName =
                        invoiceNo + ".pdf";
            }


            request.setFileName(fileName);


            // -------------------------------------------------
            // PDF → Base64
            // -------------------------------------------------

            byte[] pdfBytes =
                    pdf.getBytes();


            String base64Pdf =
                    Base64.getEncoder()
                            .encodeToString(pdfBytes);


            request.setPdf(base64Pdf);


            // -------------------------------------------------
            // Call .NET Mail Microservice
            // -------------------------------------------------

            String url =
                    mailServiceUrl
                    + "/api/mail/send-invoice";


            String response =
                    restTemplate.postForObject(
                            url,
                            request,
                            String.class
                    );


            // -------------------------------------------------
            // Success
            // -------------------------------------------------

            return ResponseEntity.ok(
                    response
            );

        }
        catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body(
                            "Unable to send mail: "
                            + e.getMessage()
                    );
        }
    }
}