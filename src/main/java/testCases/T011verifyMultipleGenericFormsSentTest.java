package testCases;

import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import setup.Setup;

public class T011verifyMultipleGenericFormsSentTest extends Setup {
    /**
     * the test creates file and writes in it random email and message for 30 different users
     * clicks on contact us button from the bottom of the home page
     * fills out a required fields to send a user message 30 times
     * and verifies if each message has been sent successfully
     */
    @Test
    public void verifyMultipleGenericFormsSent() {

        createFileWithRandomData();

        HomePage homePage = new HomePage(driver);

        ContactUsPage contactUsPage = homePage.clickOnContactUsBtn();

        contactUsPage.verifyContactUsFormFromGeneratedDataFromFile();
    }
}


