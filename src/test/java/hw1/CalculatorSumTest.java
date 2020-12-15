package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test(dataProvider = "sumDataSetDouble", dataProviderClass = TestDataProvider.class)
    public void sumDoubleTest(double a, double b, double expected) {
        double actual;
        actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(dataProvider = "sumDataSetLong", dataProviderClass = TestDataProvider.class)
    public void sumLongTest(long a, long b, long expected) {
        double actual;
        actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
