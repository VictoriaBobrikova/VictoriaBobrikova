package hw6.dataProvider;

import hw6.entities.MetalsAndColors;
import org.testng.annotations.DataProvider;

import java.util.List;

public class MetalsColorsDataSet {

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
    public Object[] data() {
        List<MetalsAndColors> list = ReadJsonFileData.readJson();
        return list.toArray();
    }
}
