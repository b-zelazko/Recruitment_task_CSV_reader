package pl.bzelazko.recruitment.csvreader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemReportCalculatorTest {

    private final String[][] calculationCase1 = {{"supply", "1"}, {"buy", "1"}, {"supply", "1"}, {"buy", "1"}};
    private final String[][] calculationCase2 = {{"supply", "500"}, {"buy", "0"}, {"supply", "500"}, {"buy", "0"}};
    private final String[][] calculationCase3 = {{"supply"}, {"buy", "500"}, {"supply", "0"}, {"buy", "500"}};


    @Test

    public void case1ShouldEqualZero() {
        var irc = new ItemReportCalculator();
        for (String[] x : calculationCase1) {
            irc.sumRow(x);
        }
        assertEquals("""
                Daily operations report
                Supply: 2
                Buy: 2
                Summary: 0""", irc.getReport());
    }

    @Test

    public void case2ShouldEqualThousand() {
        var irc = new ItemReportCalculator();
        for (String[] x : calculationCase2) {
            irc.sumRow(x);
        }
        assertEquals("""
                Daily operations report
                Supply: 1000
                Buy: 0
                Summary: 1000""", irc.getReport());
    }

    @Test

    public void case3ShouldThrowException() {
        var irc = new ItemReportCalculator();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (String[] x : calculationCase3) {
                irc.sumRow(x);
            }
        });

    }
}

