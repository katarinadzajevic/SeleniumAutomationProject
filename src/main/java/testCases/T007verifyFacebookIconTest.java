package testCases;

import org.testng.annotations.Test;
import pages.FacebookPage;
import pages.HomePage;
import setup.Setup;

public class T007verifyFacebookIconTest extends Setup {
    /**
     * the test clicks on facebook icon form the menu at the bottom of the page
     * and verifies if the button leads to the appropriate page
     */
    @Test
    public void verifyFacebookIcon(){

        String url = "facebook.com";

        HomePage homePage = new HomePage(driver);
        FacebookPage facebookPage = homePage.clickFacebookIcon();
        facebookPage.verifyFacebookIcon(url);
    }
}
