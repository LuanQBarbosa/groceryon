package business.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import business.model.User;

public class ReportGeneratorPDF extends ReportGeneratorTemplate {
    private static Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
    Font.BOLD);
    private static Font subtitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
    Font.BOLD);


    @Override
    public void exportReport(String title, String subtitle, User user, String datetime)
            throws FileNotFoundException {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("report.pdf"));
            document.open();
            document.add(new Paragraph(title, titleFont));
            document.add(new Paragraph(subtitle, subtitleFont));
            document.add(new Paragraph(" ")); // empty line
            document.add(new Paragraph("Report generated by: " + user.getLogin()));
            document.add(new Paragraph("Date and time of generation: " + datetime));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
    }
}