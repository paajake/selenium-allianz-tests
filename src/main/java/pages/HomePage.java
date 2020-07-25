package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    private static HomePage instance = null;
    private String[] zipCodes = {"97074", "97491", "97488", "28195", "28197", "28199", "28201", "28203", "28205",
            "27568", "27570", "27572", "27574", "27576", "27578", "27580"};
    private final By privacyCookiesAcceptButton = By.className("optanon-button-allow");
    private final By birthDateField = By.cssSelector("input[formcontrolname='birthdate']");
    private final By houseSizeField = By.cssSelector("input[formcontrolname='size']");
    private final By zipCodeField = By.cssSelector("input[formcontrolname='zip']");
    private final By habitationDropdownField = By.cssSelector("nx-dropdown[formcontrolname='inhabited']");
    private final By calculateTariffButton = By.cssSelector("button[nxbutton='emphasis']");

    private HomePage(WebDriver driver){
        this.driver = driver;
        clickPrivacyCookiesAcceptButton();
    }

    public static HomePage getInstance(WebDriver driver) {
        if(instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    private void clickPrivacyCookiesAcceptButton(){
        driver.findElement(privacyCookiesAcceptButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(birthDateField)));

    }

    public void setBirthDateField(String birthDate){
        driver.findElement(birthDateField).sendKeys(birthDate);
    }

    public void setHouseSizeField(String size){
        driver.findElement(houseSizeField).sendKeys(size);
    }

    public void setZipCodeField(String zip){
        driver.findElement(zipCodeField).sendKeys(zip);
    }

    private Select findHabitationDropdownElement(){
        return new Select(driver.findElement(habitationDropdownField));
    }

    public void setHabitationDropdownField(int habitationStatus){
        Select habitationDropdown = findHabitationDropdownElement();
        habitationDropdown.selectByIndex(habitationStatus);
    }

    public String getSelectedHabitationOption(){
        WebElement selectedElement = findHabitationDropdownElement().getFirstSelectedOption();
        return selectedElement.getText();
    }

    public void clickCalculateTariffButton(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculateTariffButton)));

        driver.findElement(calculateTariffButton).click();
    }

    public String getZipCode(int index){
        return zipCodes[index];
    }
}
