package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileApplicationPage {
    private final WebDriver driver;
    private final By pageHeadline = By.className("nx-heading--page");

    public FileApplicationPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getHeadlineText() {
        return driver.findElement(pageHeadline).getText();
    }
}
