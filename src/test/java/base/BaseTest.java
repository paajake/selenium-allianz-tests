package base;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Listeners(RetryTestListener.class)

public class BaseTest {
    protected HomePage homePage;
    protected Faker faker = new Faker(new Locale("de"));
    private WebDriver driver;

    private void setUpFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions().addArguments("--headless");
        driver = new FirefoxDriver(options);
    }

    private void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @BeforeClass
    protected void setUp() {
        setupLogger();

        String browser = System.getProperty("browser");
        if ("firefox".equals(browser)) {
            setUpFirefox();
        } else {
            setUpChrome();
        }

        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    protected void goToHome() {
        driver.get("https://hausrat.allianz.de/");
        homePage = HomePage.getInstance(driver);
    }

    @AfterMethod
    protected void captureFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
    }

    protected void takeScreenshot(String name) {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            Files.move(screenshot, new File("resources/screenshots/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupLogger() {
        Logger.getRootLogger().setLevel(Level.INFO);
//        Logger logger = Logger.getLogger("TestsLogger");
//        logger.setLevel(Level.INFO);
        BasicConfigurator.configure();
    }
}
