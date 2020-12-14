package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GooglePlusPage extends PageComponents{

    public GooglePlusPage(WebDriver driver) {
        super(driver);
    }
    /**
     * the method checks if the Google+ icon from the menu at the bottom of the page leads to the right page
     */
    public GooglePlusPage verifyGooglePlusIcon(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text),"Wrong page URL");
        return this;
    }
}
