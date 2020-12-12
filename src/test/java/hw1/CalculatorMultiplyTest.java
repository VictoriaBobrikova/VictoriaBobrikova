package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {

    @DataProvider
    public Object[][] multiplyDataSetDouble() {
        return new Object[][] {
                {2.0, 5.0, 10.0},
                {2.1, -3.4, -7.14},
                {-621.0, -13.9, 8631.9},
                {-1098.89, 0.0, 0.0}
        };
    }

    @Test(dataProvider = "multiplyDataSetDouble")
    public void multiplyDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @DataProvider
    public Object[][] multiplyDataSetLong() {
        return new Object[][] {
                {3L, 1L, 3L},
                {34L, -102L, -3468L},
                {-69L, -13L, 897L},
                {-10023L, 0, 0}
        };
    }

    @Test(dataProvider = "multiplyDataSetLong")
    public void multiplyLongTest(long a, long b, long expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
