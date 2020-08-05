package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FileApplicationPage extends BasePage {
//    private final By pageHeadline = By.className("nx-heading--page");
    @FindBy(how = How.CLASS_NAME, using = "nx-heading--page")
    private WebElement pageHeadline;

//    private final By totalTextInNavigation = By.cssSelector("div[nxttoolbarright]");
    @FindBy(how = How.CSS, using = "div[nxttoolbarright]")
    private WebElement totalTextInNavigation;

//    private final By birthDateField = By.cssSelector("input[formcontrolname='birthdate']");
    @FindBy(how = How.CSS, using = "input[formcontrolname='birthdate']")
    private WebElement birthDateField;

//    private final By zipCodeField = By.cssSelector("input[formcontrolname='zipcode']");
    private WebElement zipCodeField;

    public FileApplicationPage(WebDriver driver) {
        super(driver);
    }
    public String getHeadlineText() {
        return pageHeadline.getText();
    }

    public String getTotalFromNavigation(){
//        waitForElementToBeClickable(totalTextInNavigation);
        return totalTextInNavigation.getText();
    }

    public String getBirthDateText(){
//        waitForElementToBeClickable(birthDateField);
        return birthDateField.getAttribute("value");
    }

    public String getZipCodeText(){
//        waitForElementToBeClickable(zipCodeField);
        return zipCodeField.getAttribute("value");
    }


}
