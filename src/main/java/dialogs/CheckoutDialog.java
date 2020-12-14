package dialogs;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.PageComponents;

public class CheckoutDialog extends PageComponents {

    private  String continueShopping = "//span[@title='Continue shopping']";
    private  String proceedToCheckout = "//a[@title='Proceed to checkout']";

    public CheckoutDialog(WebDriver driver) {
        super(driver);
    }


    /**
     * the method clicks on check out button and leads to cart Page
     */
    public CartPage checkout(){
        waitForDisplayedElement(proceedToCheckout).click();
        return new CartPage(driver);
    }
}
