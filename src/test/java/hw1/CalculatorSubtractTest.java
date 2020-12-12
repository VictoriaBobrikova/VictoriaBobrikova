package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] subDataSetDouble() {
        return new Object[][] {
                {3.0, 0.0, 3.0},
                {45.4, 200.8, -155.4},
                {-7.0, -0.8, -6.2},
                {1008, -0.2, 1008.2}
        };
    }

    @Test(dataProvider = "subDataSetDouble")
    public void subDoubleTest(double a, double b, double expected) {
        double actual;
        actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @DataProvider
    public Object[][] subDataSetLong() {
        return new Object[][] {
                {3L, 0, 3L},
                {45L, 200L, -155L},
                {-7L, -1L, -6L},
                {1000, -891L, 1891L}
        };
    }

    @Test(dataProvider = "subDataSetLong")
    public void subLongTest(long a, long b, long expected) {
        double actual;
        actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
