package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest extends AbstractCalculatorTest {


    @Test(dataProvider = "multiplyDataSetDouble", dataProviderClass = TestDataProvider.class)
    public void multiplyDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 1);
    }


    @Test(dataProvider = "multiplyDataSetLong", dataProviderClass = TestDataProvider.class)
    public void multiplyLongTest(long a, long b, long expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.000001);
    }
}
