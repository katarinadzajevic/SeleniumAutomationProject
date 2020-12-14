package pages;

import dialogs.CheckoutDialog;
import dialogs.DressesDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SummerDressesPage extends PageComponents{

    private String secondDress = "//img[@src='http://automationpractice.com/img/p/1/6/16-home_default.jpg']";
    private  String quantity = "//a[@class='btn btn-default button-plus product_quantity_up']";
    private  String whiteColor = "//a[@name='White']";
    private  String submit = "//button[@name='Submit']";
    private  String checkout = "//a[@title='Proceed to checkout']";
    private String dressesBtn = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a";

    public SummerDressesPage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method verifies the page URL
     */
    public SummerDressesPage verifySummerDressesURL(){
        verifyCurrentURL("http://automationpractice.com/index.php?id_category=11&controller=category");
        return this;
    }
    /**
     * the method gets the page URL
     */
    public String getCurrentURL(){
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }
    /**
     * the method selects M size of the product
     */
    public SummerDressesPage selectMsize(){
        WebElement sizeDropdown = driver.findElement(By.id("group_1"));
        Select dropdown = new Select(sizeDropdown);
        dropdown.selectByIndex(1);
        return this;
    }
    /**
     * the method picks two pieces of the second dress from the list in M size and white color
     */
    public SummerDressesPage byTwoDressesSizeMcolorWhite(){
        waitForDisplayedElement(secondDress).click();
        waitForDisplayedElement(quantity).click();
        selectMsize();
        waitForDisplayedElement(whiteColor).click();
        return this;
    }
    /**
     * the method adds product to the cart
     */
    public CheckoutDialog addToCart(){
        waitForDisplayedElement(submit).click();
        return new CheckoutDialog(driver);
    }
    /**
     * the method hovers Dresses button from the Dresses Dialog
     */
    public DressesDialog dressesTab(){
        WebElement dressses = waitForDisplayedElement(dressesBtn);
        hover(dressses);
        return new DressesDialog(driver);
    }

}
