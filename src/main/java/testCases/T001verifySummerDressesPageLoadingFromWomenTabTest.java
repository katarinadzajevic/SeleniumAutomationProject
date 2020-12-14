package testCases;

import dialogs.WomenDialog;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SummerDressesPage;
import setup.Setup;

public class T001verifySummerDressesPageLoadingFromWomenTabTest extends Setup {

    /**
     * the test hovers WOMEN button from the home page dialog, clicks on summer dresses button and verifies the page URL
     */
    @Test
    public void T001verifySummerDressesPageLoadingFromWomenTab(){

        HomePage homePage = new HomePage(driver);

        WomenDialog womenDialog = homePage.womanTab();

        SummerDressesPage summerDresses = womenDialog.summerDresses();

        summerDresses.verifySummerDressesURL();

    }
}
