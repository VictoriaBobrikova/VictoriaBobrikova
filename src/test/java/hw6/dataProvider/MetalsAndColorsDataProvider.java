package hw6.dataProvider;

import hw6.entities.MetalsAndColors;
import hw6.utils.ReadJsonFileData;
import org.testng.annotations.DataProvider;

import java.util.List;

public class MetalsAndColorsDataProvider {

    @DataProvider
    public Object[] metalsAndColorsData() {
        String filePath = "src/test/resources/hw6/JDI_ex8_metalsColorsDataSet.json";
        List<MetalsAndColors> listMetalsAndColors = ReadJsonFileData.readJson(filePath);
        return listMetalsAndColors.toArray();
    }
}