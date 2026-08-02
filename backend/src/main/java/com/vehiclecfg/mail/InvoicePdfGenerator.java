package com.vehiclecfg.mail;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Component;

import java.awt.Color;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.vehiclecfg.entities.Invoice;

@Component
public class InvoicePdfGenerator {

    public byte[] generateInvoice(Invoice invoice) {

        try {

            ByteArrayOutputStream output =
                    new ByteArrayOutputStream();

            Document document =
                    new Document();

            PdfWriter.getInstance(document, output);

            document.open();

            /* ---------- Company Logo ---------- */

            Image logo =
                    Image.getInstance("src/main/resources/static/images/logo.jpeg");

            logo.scaleToFit(70,70);

            logo.setAlignment(Image.LEFT);

            document.add(logo);

            /* ---------- Company Name ---------- */

            Font companyFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            22
                    );

            Paragraph company =
                    new Paragraph(
                            "9 Wheels Leasing Services Pvt. Ltd.",
                            companyFont
                    );

            company.setAlignment(Element.ALIGN_CENTER);

            document.add(company);

            document.add(new Paragraph(
                    "221B, Assembly Road, Pune, Maharashtra - 411001"
            ));

            document.add(new Paragraph(
                    "Phone : +91 9876543210"
            ));

            document.add(new Paragraph(
                    "Email : sales@9wheels.com"
            ));

            document.add(new Paragraph(" "));

            /* ---------- Invoice Header ---------- */

            PdfPTable header =
                    new PdfPTable(2);

            header.setWidthPercentage(100);

            PdfPCell left =
                    new PdfPCell();

            left.setBorder(Rectangle.NO_BORDER);

            left.addElement(
                    new Phrase(
                            "Invoice No : INV-" +
                            invoice.getInvId()
                    )
            );

            left.addElement(
                    new Phrase(
                            "Invoice Date : " +
                            invoice.getInvDate()
                    )
            );

            PdfPCell right =
                    new PdfPCell();

            right.setBorder(Rectangle.NO_BORDER);

            right.addElement(
                    new Phrase(
                            "Customer : " +
                            invoice.getUser().getCompanyName()
                    )
            );

            right.addElement(
                    new Phrase(
                            invoice.getUser().getCompanyEmail()
                    )
            );

            header.addCell(left);

            header.addCell(right);

            document.add(header);

            document.add(new Paragraph(" "));

            /* ---------- Vehicle Details ---------- */

            document.add(
                    new Paragraph(
                            "Vehicle Details",
                            FontFactory.getFont(
                                    FontFactory.HELVETICA_BOLD,
                                    16
                            )
                    )
            );

            document.add(
                    new Paragraph(
                            "Model : " +
                            invoice.getModel().getModelName()
                    )
            );

            document.add(
                    new Paragraph(
                            "Manufacturer : " +
                            invoice.getModel()
                                   .getMfgmaster()
                                   .getMfgName()
                    )
            );

            document.add(
                    new Paragraph(
                            "Segment : " +
                            invoice.getModel()
                                   .getSegment()
                                   .getSegName()
                    )
            );

            document.add(new Paragraph(" "));

            /* ---------- Invoice Table ---------- */

            PdfPTable table =
                    new PdfPTable(4);

            table.setWidthPercentage(100);

            table.setWidths(new float[]{5,45,20,30});

            Font headerFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            12,
                            Color.WHITE
                    );

            PdfPCell cell;

            cell = new PdfPCell(new Phrase("#", headerFont));
            cell.setBackgroundColor(new Color(34,87,122));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Description", headerFont));
            cell.setBackgroundColor(new Color(34,87,122));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Amount", headerFont));
            cell.setBackgroundColor(new Color(34,87,122));
            table.addCell(cell);

            cell = new PdfPCell(new Phrase("Total", headerFont));
            cell.setBackgroundColor(new Color(34,87,122));
            table.addCell(cell);

            /* ---------- Base Vehicle ---------- */

            table.addCell("1");

            table.addCell(
                    invoice.getModel().getModelName()
            );

            table.addCell(
                    "₹ " + invoice.getTotalAmt()
            );

            table.addCell(
                    "₹ " + invoice.getTotalAmt()
            );

            document.add(table);

            document.add(new Paragraph(" "));

            /* ---------- Summary ---------- */

            PdfPTable totalTable =
                    new PdfPTable(2);

            totalTable.setWidthPercentage(45);

            totalTable.setHorizontalAlignment(Element.ALIGN_RIGHT);

            totalTable.addCell("Subtotal");

            totalTable.addCell(
                    "₹ " +
                    invoice.getTotalAmt()
            );

            totalTable.addCell("GST (12%)");

            totalTable.addCell(
                    "₹ " +
                    invoice.getTax()
            );

            PdfPCell grandTitle =
                    new PdfPCell(
                            new Phrase(
                                    "Grand Total"
                            )
                    );

            grandTitle.setBackgroundColor(
                    new Color(34,87,122)
            );

            grandTitle.setPhrase(
                    new Phrase(
                            "Grand Total",
                            headerFont
                    )
            );

            totalTable.addCell(grandTitle);

            PdfPCell grandValue =
                    new PdfPCell(
                            new Phrase(
                                    "₹ " +
                                    invoice.getNetAmt(),
                                    headerFont
                            )
                    );

            grandValue.setBackgroundColor(
                    new Color(34,87,122)
            );

            totalTable.addCell(grandValue);

            document.add(totalTable);

            document.add(new Paragraph(" "));

            Paragraph thanks =
                    new Paragraph(

                            "Thank you for choosing 9 Wheels Leasing Services.",

                            FontFactory.getFont(
                                    FontFactory.HELVETICA_BOLD,
                                    14
                            )

            );

            thanks.setAlignment(Element.ALIGN_CENTER);

            document.add(thanks);

            Paragraph footer =
                    new Paragraph(

                            "This is a computer generated invoice and does not require a signature.",

                            FontFactory.getFont(
                                    FontFactory.HELVETICA,
                                    10
                            )

            );

            footer.setAlignment(Element.ALIGN_CENTER);

            document.add(footer);

            document.close();

            return output.toByteArray();

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }

}