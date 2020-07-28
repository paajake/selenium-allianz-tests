package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileApplicationPage extends BasePage {
    private final By pageHeadline = By.className("nx-heading--page");

    public FileApplicationPage(WebDriver driver) {
        super(driver);
    }
    public String getHeadlineText() {
        return driver.findElement(pageHeadline).getText();
    }
}
