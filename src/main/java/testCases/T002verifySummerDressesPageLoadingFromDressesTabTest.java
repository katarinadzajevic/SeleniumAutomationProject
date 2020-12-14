package testCases;

import dialogs.DressesDialog;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SummerDressesPage;
import setup.Setup;

public class T002verifySummerDressesPageLoadingFromDressesTabTest extends Setup {

    /**
     * the test hovers DRESSES button from the home page dialog, clicks on summer dresses button and verifies the page URL
     */
    @Test
    public void verifySummerDressesPageLoadingFromDressesTab(){

        HomePage homePage = new HomePage(driver);

        DressesDialog dressesDialog = homePage.dressesTab();

        SummerDressesPage summerDresses = dressesDialog.summerDresses();

        summerDresses.verifySummerDressesURL();

    }
}
