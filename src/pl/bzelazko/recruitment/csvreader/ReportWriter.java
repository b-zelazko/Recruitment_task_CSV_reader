package pl.bzelazko.recruitment.csvreader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class ReportWriter {

    public static void saveFile(String textFile) throws IOException {

        File f = new File("report\\report.txt");
        if(f.createNewFile()){
            System.out.println("Creating new file...");
        }

        if (f.canWrite()) {
            try (FileWriter writer = new FileWriter(f); Formatter fm = new Formatter(writer)) {
                fm.format("%s \n", textFile);

            }

        } else {
            System.out.println("Can't save the report file");
        }
    }
}

