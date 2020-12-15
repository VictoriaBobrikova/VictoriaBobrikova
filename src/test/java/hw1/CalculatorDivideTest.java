package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends AbstractCalculatorTest {


    @Test(dataProvider = "divideDataSetDouble", dataProviderClass = TestDataProvider.class)
    public void divideDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }


    @Test(dataProvider = "divideDataSetLong", dataProviderClass = TestDataProvider.class)
    public void divideLongTest(long a, long b, long expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test
    public void divideByZeroDoubleTest() throws NumberFormatException {
        double actual = calculator.div(19.2, 0);
        assertEquals(actual, Double.POSITIVE_INFINITY);
    }

    @Test(expectedExceptions = java.lang.NumberFormatException.class)
    public void divideByZeroLongTest() throws NumberFormatException {
        calculator.div(40, 0);
    }
}
