package pl.bzelazko.recruitment.csvreader;

public class ItemReportCalculator {
    private int buy = 0;
    private int supply = 0;

    public void sumRow(String[] data) {

        switch (data[0]) {
            case "supply" -> supply += Integer.parseInt(data[1]);
            case "buy" -> buy += Integer.parseInt(data[1]);
        }
    }

    public String getReport() {
        return ("Daily operations report\nSupply: " + supply + "\nBuy: " + buy +
                "\nSummary: " + (supply - buy));
    }

}
