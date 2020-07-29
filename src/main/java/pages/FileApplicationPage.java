package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileApplicationPage extends BasePage {
    private final By pageHeadline = By.className("nx-heading--page");
    private final By totalTextInNavigation = By.cssSelector("div[nxttoolbarright]");
    private final By birthDateField = By.cssSelector("input[formcontrolname='birthdate']");
    private final By zipCodeField = By.cssSelector("input[formcontrolname='zipcode']");

    public FileApplicationPage(WebDriver driver) {
        super(driver);
    }
    public String getHeadlineText() {
        return driver.findElement(pageHeadline).getText();
    }

    public String getTotalFromNavigation(){
        waitForElementToBeClickable(totalTextInNavigation);
        return driver.findElement(totalTextInNavigation).getText();
    }

    public String getBirthDateText(){
        waitForElementToBeClickable(birthDateField);
        return driver.findElement(birthDateField).getAttribute("value");
    }

    public String getZipCodeText(){
        waitForElementToBeClickable(zipCodeField);
        return driver.findElement(zipCodeField).getAttribute("value");
    }


}
