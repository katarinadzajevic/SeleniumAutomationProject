package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageComponents {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageComponents(WebDriver driver){
        this.driver = driver;
    }

    /**
     * the method waits ten seconds until the element on the page appears, than finds element by xPath
     */
    protected WebElement waitForDisplayedElement(String locator){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath(locator))));
        return driver.findElement(By.xpath(locator));
    }
    /**
     * the method hovers the element from the page
     */
    protected void hover(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    /**
     * the method verifies the page URL
     */
    protected void verifyCurrentURL(String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Wrong URL");
    }
    /**
     * the method compares URL of different pages
     */
    public void compareURLs(String URL1, String URL2){
        Assert.assertEquals(URL1, URL2, "Compared URLs are different");
    }
}
