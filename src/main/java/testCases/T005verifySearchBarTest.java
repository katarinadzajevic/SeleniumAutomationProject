package testCases;

import org.testng.annotations.Test;
import pages.HomePage;
import setup.Setup;

public class T005verifySearchBarTest extends Setup {
    /**
     * the test types "yellow" in the search bar and verifies the number of displayed products
     * also checks if they can all be bought in yellow
     */
    @Test
    public void verifySearchBar(){

        String text = "yellow";

        HomePage homePage = new HomePage(driver);

        homePage.typeInSearchBar(text).verifyFeaturesOfDisplayedElements();

    }
}
