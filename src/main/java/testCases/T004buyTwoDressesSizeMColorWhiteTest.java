package testCases;

import dialogs.CheckoutDialog;
import dialogs.WomenDialog;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.SummerDressesPage;
import setup.Setup;

public class T004buyTwoDressesSizeMColorWhiteTest extends Setup {
    /**
     * the test hovers WOMEN button from home page dialog, clicks on summer dresses button,
     * picks two pieces of the second dress from the list in M size and white color, adds products to the cart
     * and verifies if there is the right product in the cart and if it is in the appropriate color, size and quantity
     */
    @Test
    public void buyTwoDressesSizeMColorWhite(){

        HomePage homePage = new HomePage(driver);

        WomenDialog womenDialog = homePage.womanTab();

        SummerDressesPage summerDressesPage = womenDialog.summerDresses();

        summerDressesPage.byTwoDressesSizeMcolorWhite();

        CheckoutDialog checkoutDialog = summerDressesPage.addToCart();

        CartPage cartPage = checkoutDialog.checkout();

        cartPage.verifyTheFeaturesOfTheDress();

    }
}
