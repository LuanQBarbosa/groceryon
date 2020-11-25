package business.report;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import business.model.User;

public abstract class ReportGeneratorTemplate {
    public abstract void exportReport(String title, String subtitle, User user, String datetime)
            throws IOException;

    public void generateReport(String title, String subtitle, User user) throws IOException {
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = datetime.format(formatter);
        exportReport(title, subtitle, user, formattedDate);
    }
}