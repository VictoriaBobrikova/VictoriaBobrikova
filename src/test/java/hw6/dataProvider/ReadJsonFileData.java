package hw6.dataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw6.entities.MetalsAndColors;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadJsonFileData {

    private static String filePath = "JDI_ex8_metalsColorsDataSet.json";

    public static List<MetalsAndColors> readJson() {

        List<MetalsAndColors> listDataMetalsAndColors = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream fis = new FileInputStream(filePath);

            HashMap<String, MetalsAndColors> map = mapper.readValue(fis,
                    new TypeReference<HashMap<String, MetalsAndColors>>() {});

            for(Map.Entry<String, MetalsAndColors> entry : map.entrySet()){
                listDataMetalsAndColors.add(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listDataMetalsAndColors;
    }
}
