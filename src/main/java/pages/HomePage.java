package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private final WebDriver driver;
    private static HomePage instance = null;
    private final By privacyCookiesAcceptButton = By.className("optanon-button-allow");
    private final By birthDateField = By.cssSelector("input[formcontrolname='birthdate']");
    private final By houseSizeField = By.cssSelector("input[formcontrolname='size']");
    private final By zipCodeField = By.cssSelector("input[formcontrolname='zip']");
    private final By habitationDropdownField = By.cssSelector("input[formcontrolname='inhabited']");
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
        driver.findElement(calculateTariffButton).click();
    }

}
