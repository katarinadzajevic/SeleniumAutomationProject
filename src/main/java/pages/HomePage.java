package pages;

import dialogs.DressesDialog;
import dialogs.WomenDialog;
import menus.FollowUsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class HomePage extends FollowUsMenu {

    private String womenBtn = "//a[@title='Women']";
    private String dressesBtn = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a";
    private String searchBar = "//input[@id='search_query_top']";
    private String submitSearch = "//button[@name='submit_search']";
    private String numberOfDisplayedItems = "//span[@class='heading-counter']";
    private String contactUs = "//a[@title='Contact Us']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * the method hovers Women button at the Home Page
     */
    public WomenDialog womanTab(){
        WebElement women = waitForDisplayedElement(womenBtn);
        hover(women);
        return new WomenDialog(driver);
      }
    /**
     * the method hovers Dresses button at the Home Page
     */
      public DressesDialog dressesTab(){
        WebElement dressses = waitForDisplayedElement(dressesBtn);
        hover(dressses);
        return new DressesDialog(driver);
      }
    /**
     * the method types text in the search bar and clicks on it
     */
      public HomePage typeInSearchBar(String text){
        waitForDisplayedElement(searchBar).sendKeys(text);
        waitForDisplayedElement(submitSearch).click();
        return this;
      }

    /**
     * the method gets the number of displayed products
     */
        private String getNumberOfDisplayedItems(){
        return waitForDisplayedElement(numberOfDisplayedItems).getText();
      }

    /**
     * the method takes all the products shown and checks if they can all be bought in yellow
     */
    private boolean verifyIfAllOfTheShownItemsCanBePurchasedInYellow(){

        boolean haveTheRequiredColor = false;
        int counter = 0;
              List<WebElement> colors = driver.findElements(By.xpath("//div[@class='product-container']//ul"));
              for (int i = 0; i < colors.size(); i++) {
                  List <WebElement> colorToPick = colors.get(i).findElements(By.xpath(".//a"));
                  for (int j = 0; j < colorToPick.size(); j++) {
                      if (colorToPick.get(j).getAttribute("style").contains("background: rgb(241, 196, 15);")){
                        counter++;
                      }
                  }
              }
              if (counter == colors.size()){
                  haveTheRequiredColor=true;
              }
          return haveTheRequiredColor;
    }

    /**
     * the method checks the number of displayed products, and checks if they can all be bought in yellow
     */
    public HomePage verifyFeaturesOfDisplayedElements(){

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(getNumberOfDisplayedItems(), "3 results have been found.");
        sa.assertTrue(verifyIfAllOfTheShownItemsCanBePurchasedInYellow());
        sa.assertAll();
        return this;
    }

    /**
     * the method clicks on contact us button at the top of the page and leads to Contact us Page
     */
    public ContactUsPage clickOnContactUsBtn(){
        waitForDisplayedElement(contactUs).click();
        return new ContactUsPage(driver);
    }
}
