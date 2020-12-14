package dialogs;

import org.openqa.selenium.WebDriver;
import pages.PageComponents;
import pages.SummerDressesPage;

public class DressesDialog extends PageComponents {

    private String summerDresses = "//div[@id='block_top_menu']/ul/li[2]/ul/li[3]/a";

    public DressesDialog(WebDriver driver) {
        super(driver);
    }

    /**
     * the method clicks on Summer Dresses button from Dresses dialog and leads to Dresses Page
     */
    public SummerDressesPage summerDresses(){
        waitForDisplayedElement(summerDresses).click();
        return new SummerDressesPage(driver);
    }
}
