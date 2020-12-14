package testCases;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import setup.Setup;

public class T006verifyContactUsFormTest extends Setup {
    /**
     * the test clicks on contact us button from the top of the home page
     * fills out a form to send a user message
     * and verifies if the message was sent successfully
     */
    @Test
    public void verifyContactUsForm(){

        String email = "admin@example.com";
        String orderReference = "Random order reference example";
        String filePath = "/home/katarina/IdeaProjects/MyStore/File.png";
        String textMessage = "Random text message example";

        HomePage homePage = new HomePage(driver);

        ContactUsPage contactUsPage = homePage.clickOnContactUsBtn();

        contactUsPage.selectWebmaster().insertEmailAddress(email).insertOrderReference(orderReference)
                .fileUpload(filePath).insertTextMessage(textMessage).sendMessage().verifyContactUsForm();
    }
}
