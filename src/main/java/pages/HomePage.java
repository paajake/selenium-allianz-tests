package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private static HomePage instance = null;
    private final WebDriver driver;
    private final String[] zipCodes = {"97074", "97491", "97488", "28195", "28197", "28199", "28201", "28203", "28205",
            "27568", "27570", "27572", "27574", "27576", "27578", "27580"};
    private final By privacyCookiesAcceptButton = By.className("optanon-button-allow");
    private final By birthDateField = By.cssSelector("input[formcontrolname='birthdate']");
    private final By houseSizeField = By.cssSelector("input[formcontrolname='size']");
    private final By zipCodeField = By.cssSelector("input[formcontrolname='zip']");
    private final By habitationDropdownField = By.cssSelector("nx-dropdown[formcontrolname='inhabited']");
    private final By calculateTariffButton = By.cssSelector("button[nxbutton='emphasis']");

    private HomePage(WebDriver driver) {
        this.driver = driver;
        clickPrivacyCookiesAcceptButton();
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    private void clickPrivacyCookiesAcceptButton() {
        driver.findElement(privacyCookiesAcceptButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(birthDateField)));

    }

    public void setBirthDateField(String birthDate) {
        driver.findElement(birthDateField).sendKeys(birthDate);
    }

    public void setHouseSizeField(String size) {
        driver.findElement(houseSizeField).sendKeys(size);
    }

    public void setZipCodeField(String zip) {
        driver.findElement(zipCodeField).sendKeys(zip);
    }

    private WebElement findHabitationDropdownElement() {
        return driver.findElement(By.className("nx-dropdown__panel-body"));
    }

    private void clickHabitationDropdownField() {
        driver.findElement(habitationDropdownField).click();
    }

    private String clickHabitationItemByIndex(int index) {
        List<WebElement> dropDownElements = findHabitationDropdownElement()
                .findElements(By.cssSelector("nx-dropdown-item[role='option']"));

        dropDownElements.get(index).click();
        return getSelectedHabitationOptionText();
    }

    public String setHabitationDropdownField(int habitationStatus) {
        clickHabitationDropdownField();
        return clickHabitationItemByIndex(habitationStatus);
    }

    public String getSelectedHabitationOptionText() {
        return driver.findElement(By.cssSelector("nx-dropdown span.ng-star-inserted")).getText();
    }

    public OffersPage clickCalculateTariffButton() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculateTariffButton)));

        driver.findElement(calculateTariffButton).click();
        return new OffersPage(driver);
    }

    public String getZipCode(int index) {
        return zipCodes[index];
    }
}
