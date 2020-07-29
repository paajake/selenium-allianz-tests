package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class BasePage {
    protected final WebDriver driver;

    public static HashMap<String, String> setTestFields = new HashMap<>();
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
