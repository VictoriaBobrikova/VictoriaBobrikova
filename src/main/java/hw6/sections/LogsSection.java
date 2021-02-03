package hw6.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import hw6.entities.MetalsAndColors;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LogsSection {

    @UI(".results li")
    public WebList logRowsResult;

    public List<String> getExpectedResultLogRows(MetalsAndColors metalsAndColors) {
        List<String> expectedResultLogRows = new ArrayList<>();
        expectedResultLogRows.add("Summary: " + metalsAndColors.getSumOfSelectedSummaryDigits());
        expectedResultLogRows.add("Elements: " + String.join(", ", metalsAndColors.getElements()));
        expectedResultLogRows.add("Color: " + metalsAndColors.getColor());
        expectedResultLogRows.add("Metal: " + metalsAndColors.getMetals());
        expectedResultLogRows.add("Vegetables: " + String.join(", ", metalsAndColors.getVegetables()));
        return expectedResultLogRows;
    }

    public List<String> getActualLogRows() {
        List<String> actualRows = new ArrayList<>();
        for (UIElement row : logRowsResult) {
            actualRows.add(row.getText());
        }
        return actualRows;
    }

    public void checkResults(MetalsAndColors metalsAndColors) {
        Assert.assertEquals(getActualLogRows(), getExpectedResultLogRows(metalsAndColors));
    }
}