package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;

public class ContactUsPage extends PageComponents {

    private String emailAddress = "//input[@id='email']";
    private String orderReference = "//input[@id='id_order']";
    private String fileUpload = "//input[@name='fileUpload']";
    private String message = "//textarea[@id='message']";
    private String sendBtn = "//button[@id='submitMessage']";
    private String messageSentSuccessfully = "//p[@class='alert alert-success']";
    private String contactUsBtn = "//a[@title='Contact Us']";
    private String customerService = "//option[text()='Customer service']";
    private String webmaster = "//option[text()='Webmaster']";


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage selectCustomerService() {
        waitForDisplayedElement(customerService).click();
        return this;
    }

    public ContactUsPage selectWebmaster() {
        waitForDisplayedElement(customerService).click();
        return this;
    }

    public ContactUsPage insertEmailAddress(String text) {
        waitForDisplayedElement(emailAddress).clear();
        waitForDisplayedElement(emailAddress).sendKeys(text);
        return this;
    }

    public ContactUsPage insertOrderReference(String text) {
        waitForDisplayedElement(orderReference).sendKeys(text);
        return this;
    }

    public ContactUsPage fileUpload(String filePath) {
        driver.findElement(By.xpath(fileUpload)).sendKeys(filePath);
        return this;
    }

    public ContactUsPage insertTextMessage(String text) {
        waitForDisplayedElement(message).clear();
        waitForDisplayedElement(message).sendKeys(text);
        return this;
    }

    public ContactUsPage sendMessage() {
        waitForDisplayedElement(sendBtn).click();
        return this;
    }

    private String getMessage() {
        WebElement message = driver.findElement(By.xpath(messageSentSuccessfully));
        return message.getText();
    }
    /**
     * the method checks if the message was sent successfully
     */
    public ContactUsPage verifyContactUsForm() {
        String message = waitForDisplayedElement(messageSentSuccessfully).getText();
        Assert.assertEquals(message, "Your message has been successfully sent to our team.", "Error sending message!");
        return this;
    }

    /**
     * the method clicks on contact us button at the top of the page
     */
    private ContactUsPage clickContactUsBtn() {
        waitForDisplayedElement(contactUsBtn).click();
        return this;
    }

    /**
     *the method takes the data for the required fields from the file
     * sends the message 30 times
     * and checks if the message was sent successfully
     */
    public ContactUsPage verifyContactUsFormFromGeneratedDataFromFile() {

        SoftAssert softAssert = new SoftAssert();

        for (int i = 1; i < 31; i++) {
            try {
                FileInputStream fis;
                XSSFWorkbook wb;
                Cell email = null;
                Cell message = null;
                fis = new FileInputStream("Data.xlsx");
                wb = new XSSFWorkbook(fis);
                Sheet sheet = wb.getSheetAt(0);
                Row row = sheet.getRow(i);
                email = row.getCell(0);
                message = row.getCell(1);

                selectCustomerService().insertEmailAddress(email.toString())
                        .insertTextMessage(message.toString()).sendMessage();
               softAssert.assertEquals(getMessage(), "Your message has been successfully sent to our team.","Error sending message!");
                clickContactUsBtn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        softAssert.assertAll();

        return this;
    }

}

