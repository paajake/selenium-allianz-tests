package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class BasePage {
    protected final WebDriver driver;

    public HashMap<String, String> filledData;
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
