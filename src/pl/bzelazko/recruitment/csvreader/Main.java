package pl.bzelazko.recruitment.csvreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
        String line = "";
        ItemReportCalculator rc = new ItemReportCalculator();
        try (BufferedReader inputFile = Files.newBufferedReader(Paths.get("ItemX.csv"))) {
            while ((line = inputFile.readLine()) != null) {
                rc.sumRow(line.split(","));
            }
            String summary = rc.getReport();
            ReportWriter.saveFile(summary);
            System.out.println("Report has been updated!");
        } catch (IOException e) {
            System.err.println("Unable to create report: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("CSV File formatted incorrectly/Missing parameters in CSV file: " + e.getMessage());
        }


    }
}

