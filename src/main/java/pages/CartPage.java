package pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class CartPage extends PageComponents {

    private String productName = "//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]";
    private String colorAndSize = "//td[@class='cart_description']//a[contains(text(),'Color : White, Size : M')]";
    private String quantity = "//input[@name='quantity_6_41_0_0']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method gets the product name from the cart
     * @return String
     */
    public String getProductName(){
        String product =  waitForDisplayedElement(productName).getText();
        return product;
    }

    /**
     * the method gets the color and size of the product from the cart
     */
    public String getColorAndSize(){
        String productColorAndSize =  waitForDisplayedElement(colorAndSize).getText();
        return productColorAndSize;
    }

    /**
     * the method shows the amount of a product from the cart
     */
    public String getQuantity(){
        String productQuantity =  waitForDisplayedElement(quantity).getAttribute("value");
        return productQuantity;
    }

    /**
     * the method checks if there is the right product in the cart and if it is in the appropriate color, size and quantity
     */
    public void verifyTheFeaturesOfTheDress(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getProductName(), "Printed Summer Dress", "Wrong product name.");
        softAssert.assertEquals(getColorAndSize(), "Color : White, Size : M", "Wrong color or size");
        softAssert.assertEquals(getQuantity(), "2", "Wrong amount of product");
        softAssert.assertAll();

    }
}
