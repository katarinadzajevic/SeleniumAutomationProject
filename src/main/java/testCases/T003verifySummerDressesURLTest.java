package testCases;

import dialogs.DressesDialog;
import dialogs.WomenDialog;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SummerDressesPage;
import setup.Setup;

public class T003verifySummerDressesURLTest extends Setup {

    /**
     * the test hovers WOMEN button from the home page dialog, clicks on summer dresses button, gets the current URL
     * from that page then hovers DRESSES button, clicks on summer dresses button, gets the current URL from that page
     * and compares those two URLs
     */
    @Test
    public void verifySummerDressesURL(){

        HomePage homePage = new HomePage(driver);

        WomenDialog womenDialog = homePage.womanTab();

        SummerDressesPage summerDressesPage = womenDialog.summerDresses();

        String URL1 = summerDressesPage.getCurrentURL();

        DressesDialog dressesDialog = summerDressesPage.dressesTab();

        summerDressesPage = dressesDialog.summerDresses();

        String URL2 = summerDressesPage.getCurrentURL();

        summerDressesPage.compareURLs(URL1, URL2);



    }
}
