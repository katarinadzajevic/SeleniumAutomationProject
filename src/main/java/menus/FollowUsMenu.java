package menus;

import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.ArrayList;

public class FollowUsMenu extends PageComponents {

    private String facebookIcon = "//li[@class='facebook']";
    private String twitterIcon = "//li[@class='twitter']";
    private String youTubeIcon = "//li[@class='youtube']";
    private String googlePlusIcon = "//li[@class='google-plus']";

    public FollowUsMenu(WebDriver driver) {
        super(driver);
    }

    ArrayList<String> handles;

    /**
     * the method clicks on the icons in the menu at the bottom of the page
     * and leads to the appropriate pages
     */
    public FacebookPage clickFacebookIcon(){
        waitForDisplayedElement(facebookIcon).click();
        handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return new FacebookPage(driver);
    }

    public TwitterPage clickTwitterIcon(){
        waitForDisplayedElement(twitterIcon).click();
        handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return new TwitterPage(driver);
    }

    public YouTubePage clickYouTubeIcon(){
        waitForDisplayedElement(youTubeIcon).click();
        handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return new YouTubePage(driver);
    }

    public GooglePlusPage clickGooglePlusIcon(){
        waitForDisplayedElement(googlePlusIcon).click();
        handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size() - 1));
        return new GooglePlusPage(driver);
    }

}
