package testCases;

import org.testng.annotations.Test;
import pages.GooglePlusPage;
import pages.HomePage;
import setup.Setup;

public class T010verifyGooglePlusIconTest extends Setup {
    /**
     * the test clicks on Google+ icon from the menu at the bottom of the page
     * and verifies if the button leads to the appropriate page
     */
    @Test
    public void verifyGooglePlusIcon(){

        String url = "plus.google.com";

        HomePage homePage = new HomePage(driver);
        GooglePlusPage googlePlusPage = homePage.clickGooglePlusIcon();
        googlePlusPage.verifyGooglePlusIcon(url);
    }
}
