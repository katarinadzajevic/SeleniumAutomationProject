package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class YouTubePage extends PageComponents {

    public YouTubePage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method checks if the YouTube icon from the menu at the bottom of the page leads to the right page
     */
    public YouTubePage verifyYouTubeIcon(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text),"Wrong URL");
        return this;
    }
}
