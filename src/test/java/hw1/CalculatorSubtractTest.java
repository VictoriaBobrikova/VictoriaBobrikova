package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest extends AbstractCalculatorTest {


    @Test(dataProvider = "subDataSetDouble", dataProviderClass = TestDataProvider.class)
    public void subDoubleTest(double a, double b, double expected) {
        double actual;
        actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }


    @Test(dataProvider = "subDataSetLong", dataProviderClass = TestDataProvider.class)
    public void subLongTest(long a, long b, long expected) {
        double actual;
        actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
