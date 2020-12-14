package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Setup extends TestComponents{

    protected static WebDriver driver;

    /**
     * the method using Selenium WebDriver runs google chrome, goes to the given page and maximizes the window
     */
    @BeforeMethod
    public static void setUp() {
        System.setProperty("chromedriver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    /**
     * the method quits google chrome
     */
    @AfterMethod
    public static void close() {
       driver.quit();
    }
}
