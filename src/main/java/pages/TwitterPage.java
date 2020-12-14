package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TwitterPage extends PageComponents{

    public TwitterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method checks if the Twitter icon from the menu at the bottom of the page leads to the right page
     */
    public TwitterPage verifyTwitterIcon(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text), "Wrong URL");
        return this;
    }
}
