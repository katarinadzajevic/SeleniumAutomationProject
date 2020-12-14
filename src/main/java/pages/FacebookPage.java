package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FacebookPage extends PageComponents{

    public FacebookPage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method checks if the Facebook icon from the menu at the bottom of the page leads to the right page
     */
    public FacebookPage verifyFacebookIcon(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text), "Wrong page URL");
        return this;
    }
}
