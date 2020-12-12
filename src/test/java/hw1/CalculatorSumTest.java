package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] sumDataSetDouble() {
        return new Object[][] {
                {2.0, 0.0, 2.0},
                {3.5, 4.1, 7.6},
                {-6.0, -0.9, -6.9},
                {-6, 0.9, -5.1}
        };
    }

    @Test(dataProvider = "sumDataSetDouble")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual;
        actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @DataProvider
    public Object[][] sumDataSetLong() {
        return new Object[][] {
                {2L, 2L, 4L},
                {-31L, 47L, 16L},
                {-517L, -9L, -526L},
                {-8L, 0, -8L}
        };
    }

    @Test(dataProvider = "sumDataSetLong")
    public void sumLongTest(long a, long b, long expected) {
        double actual;
        actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
