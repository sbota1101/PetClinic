package com.sbota.PetClinic.service;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.sbota.PetClinic.model.Visit;
import lombok.extern.slf4j.Slf4j;
import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.util.List;


@Slf4j
public class GeneratePdf {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);

    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);

    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);

    private static Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);

    private static Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);


    public static ByteArrayInputStream generate(List<Visit> visits) {
        Document document = new Document();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            Chunk chunk = new Chunk("visit", chapterFont);
            Paragraph title = new Paragraph(chunk);
            title.setAlignment(Element.ALIGN_CENTER);
            Chapter chapter = new Chapter(title, 1);
            chapter.add(new Paragraph(" "));
            chapter.setNumberDepth(0);
            Paragraph subtitle = new Paragraph("2020", paragraphFont);

            subtitle.setAlignment(Element.ALIGN_CENTER);
            chapter.add(subtitle);
            chapter.add(new Paragraph(" "));
            chapter.add(new Paragraph(" "));

            for (Visit visit : visits) {
                Paragraph dbParagraph = new Paragraph(
                        visit.getVisitId()+" "+visit.getDescription() + " " +" "+visit.getDate(), smallFont);
                dbParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
                chapter.add(dbParagraph);
            }
            chapter.add(new Paragraph(" "));
            document.add(chapter);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.close();

        } catch (DocumentException ex) {
            log.error("Error occurred: {0}", ex);
        }
        return new ByteArrayInputStream(out.toByteArray());

    }

}





