package testCases;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.TwitterPage;
import setup.Setup;

public class T008verifyTwitterIconTest extends Setup {
    /**
     * the test clicks on twitter icon from the menu at the bottom of the page
     * and verifies if the button leads to the appropriate page
     */
    @Test
    public void verifyTwitterIcon(){

        String url = "twitter.com";

        HomePage homePage = new HomePage(driver);
        TwitterPage twitterPage = homePage.clickTwitterIcon();
        twitterPage.verifyTwitterIcon(url);
    }
}
