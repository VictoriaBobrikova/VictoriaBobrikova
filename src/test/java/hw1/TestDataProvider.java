package hw1;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] sumDataSetDouble() {
        return new Object[][] {
                {2.0, 0.0, 2.0},
                {3.5, 4.1, 7.6},
                {-6.0, -0.9, -6.9},
                {-6, 0.9, -5.1}
        };
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

    @DataProvider
    public Object[][] subDataSetDouble() {
        return new Object[][] {
                {3.0, 0.0, 3.0},
                {45.4, 200.8, -155.4},
                {-7.0, -0.8, -6.2},
                {1008, -0.2, 1008.2}
        };
    }

    @DataProvider(name="subDataSetLong")
    public Object[][] subDataSetLong() {
        return new Object[][] {
                {3L, 0, 3L},
                {45L, 200L, -155L},
                {-7L, -1L, -6L},
                {1000, -891L, 1891L}
        };
    }

    @DataProvider
    public Object[][] multiplyDataSetDouble() {
        return new Object[][] {
                {2.0, 5.0, 10.0},
                {2.1, -3.4, -7.14},
                {-621.0, -13.9, 8631.9},
                {-1098.89, 0.0, 0.0}
        };
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

    @DataProvider
    public Object[][] divideDataSetDouble() {
        return new Object[][] {
                {2.0, 5.0, 0.4},
                {50.2, -2.0, -25.1},
                {-621.0, -4.5, 138.0},
                {0.0, 1098.89, 0.0}
        };
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
}
