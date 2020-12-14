package testCases;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.YouTubePage;
import setup.Setup;

public class T009verifyYouTubeIconTest extends Setup {
    /**
     * the test clicks on YouTube icon from the menu at the bottom of the page
     * and verifies if the button leads to the appropriate page
     */
    @Test
    public void verifyYouTubeIcon(){

        String url = "youtube.com";

        HomePage homePage = new HomePage(driver);
        YouTubePage youTubePage = homePage.clickYouTubeIcon();
        youTubePage.verifyYouTubeIcon(url);
    }
}
