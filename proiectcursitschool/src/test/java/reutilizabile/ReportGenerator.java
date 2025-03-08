package reutilizabile;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    private static final String API_REPORT_FILE = "test-report.txt";

    public static void clearReport() {
        try (FileWriter writer = new FileWriter(API_REPORT_FILE, false)) {
            writer.write("Test Execution Report\n======================\n");
        } catch (IOException e) {
            System.out.println("Error clearing report file.");
        }
    }

    public static void writeToReport(String message) {
        try (FileWriter writer = new FileWriter(API_REPORT_FILE, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to API report file.");
        }
    }
}

