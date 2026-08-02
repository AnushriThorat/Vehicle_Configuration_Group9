package com.vehiclecfg.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclecfg.entities.Invoice;
import com.vehiclecfg.entities.Model;
import com.vehiclecfg.entities.User;
import com.vehiclecfg.mail.InvoicePdfGenerator;
import com.vehiclecfg.mail.MailService;
import com.vehiclecfg.repository.InvoiceRepository;
import com.vehiclecfg.repository.ModelRepository;
import com.vehiclecfg.repository.UserRepository;
import com.vehiclecfg.services.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private InvoicePdfGenerator pdfGenerator;

    @Override
    public Invoice saveInvoice(Invoice invoice) {

        double tax = invoice.getTotalAmt() * 0.12;

        invoice.setTax(tax);

        invoice.setNetAmt(invoice.getTotalAmt() + tax);

        Invoice savedInvoice = repository.save(invoice);

        try {

            User user = userRepository
                    .findById(savedInvoice.getUser().getId())
                    .orElseThrow(() ->
                            new RuntimeException("User Not Found"));

            savedInvoice.setUser(user);

            Model model = modelRepository
                    .findById(savedInvoice.getModel().getModelId())
                    .orElseThrow(() ->
                            new RuntimeException("Model Not Found"));

            savedInvoice.setModel(model);

            byte[] pdf =
                    pdfGenerator.generateInvoice(savedInvoice);

            String subject =
                    "Order Confirmation - Invoice INV-" +
                    savedInvoice.getInvId();

            String body =
                    "Dear " + user.getCompanyName() + ",\n\n"
                  + "Thank you for choosing 9 Wheels Leasing Services.\n\n"
                  + "Your vehicle order has been confirmed successfully.\n\n"
                  + "Please find your invoice attached.\n\n"
                  + "Regards,\n"
                  + "9 Wheels Leasing Services Pvt. Ltd.";

            System.out.println("========== MAIL DEBUG ==========");
            System.out.println("User ID : " + user.getId());
            System.out.println("Company Name : " + user.getCompanyName());
            System.out.println("Company Email : " + user.getCompanyEmail());
            System.out.println("Invoice ID : " + savedInvoice.getInvId());
            System.out.println("Model : " + model.getModelName());
            System.out.println("Manufacturer : " + model.getMfgmaster().getMfgName());
            System.out.println("Segment : " + model.getSegment().getSegName());
            System.out.println("===============================");

            mailService.sendInvoiceMail(

                    user.getCompanyEmail(),

                    subject,

                    body,

                    pdf,

                    "Invoice-INV-" +
                            savedInvoice.getInvId() +
                            ".pdf"

            );

            System.out.println("Invoice Email Sent Successfully");

        }

        catch (Exception e) {

            System.out.println("EMAIL FAILED");

            e.printStackTrace();

        }

        return savedInvoice;

    }

    @Override
    public List<Invoice> getAllInvoices() {

        return repository.findAll();

    }

    @Override
    public Invoice getInvoiceById(Long id) {

        return repository.findById(id).orElse(null);

    }

    @Override
    public List<Invoice> getInvoicesByUser(Integer userId) {

        return repository.findByUserId(userId);

    }

    @Override
    public Invoice updateInvoice(Long id, Invoice invoice) {

        Invoice existing =
                repository.findById(id).orElse(null);

        if (existing == null) {

            return null;

        }

        existing.setInvDate(invoice.getInvDate());

        existing.setUser(invoice.getUser());

        existing.setModel(invoice.getModel());

        existing.setTotalAmt(invoice.getTotalAmt());

        double tax =
                invoice.getTotalAmt() * 0.12;

        existing.setTax(tax);

        existing.setNetAmt(invoice.getTotalAmt() + tax);

        return repository.save(existing);

    }

    @Override
    public void deleteInvoice(Long id) {

        repository.deleteById(id);

    }

}