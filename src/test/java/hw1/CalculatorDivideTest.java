package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] divideDataSetDouble() {
        return new Object[][] {
                {2.0, 5.0, 0.4},
                {50.2, -2.0, -25.1},
                {-621.0, -4.5, 138.0},
                {0.0, 1098.89, 0.0}
        };
    }

    @Test(dataProvider = "divideDataSetDouble")
    public void divideDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @DataProvider
    public Object[][] divideDataSetLong() {
        return new Object[][] {
                {3L, 1L, 3L},
                {-102, 34L, -3L},
                {-49L, -7L, 7L},
                {0, -10428L, 0}
        };
    }

    @Test(dataProvider = "divideDataSetLong")
    public void divideLongTest(long a, long b, long expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(expectedExceptions = java.lang.NumberFormatException.class)
    public void divideByZeroDoubleTest() throws NumberFormatException {
        calculator.div(19.2, 0);
    }

    @Test(expectedExceptions = java.lang.NumberFormatException.class)
    public void divideByZeroLongTest() throws NumberFormatException {
        calculator.div(40, 0);
    }
}
