package pages;

import base.BasePage;
import base.VisibleAjaxElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends BasePage {
    private static HomePage instance = null;
    private final Map<String, String> zipcodes = new HashMap<>();

    private final By privacyCookiesAcceptButton = By.className("optanon-button-allow");

    @FindBy(how = How.CSS, using = "input[formcontrolname='birthdate']")
    private WebElement birthDateField;

    @FindBy(how = How.CSS, using = "input[formcontrolname='size']")
    private WebElement houseSizeField;

    @FindBy(how = How.CSS, using = "input[formcontrolname='zip']")
    private WebElement zipCodeField;

    @FindBy(how = How.CSS, using = "nx-dropdown[formcontrolname='inhabited']")
    private WebElement habitationDropdownField;

    @FindBy(how = How.CSS, using = "button[nxbutton='emphasis']")
    private WebElement calculateTariffButton;

    @FindBy(how = How.CSS, using = "nx-dropdown span.ng-star-inserted")
    private WebElement selectedHabitationOption;


    private HomePage(WebDriver driver) {
        super(driver);
        setzipcodes();
        clickPrivacyCookiesAcceptButton();
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public static HomePage getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new HomePage(driver);
        }
        return instance;
    }

    private void clickPrivacyCookiesAcceptButton() {
        driver.findElement(privacyCookiesAcceptButton).click();
    }

    public void setBirthDateField(String birthDate) {
        birthDateField.sendKeys(birthDate);
    }

    public void setHouseSizeField(String size) {
        houseSizeField.sendKeys(size);
    }

    public void setZipCodeField(String zip) {
        zipCodeField.sendKeys(zip);
    }

    private WebElement findHabitationDropdownElement() {
        return driver.findElement(By.className("nx-dropdown__panel-body"));
    }

    private void clickHabitationDropdownField() {
        habitationDropdownField.click();
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
        return selectedHabitationOption.getText();
    }

    public OffersPage clickCalculateTariffButton() {
        calculateTariffButton.click();
        return new OffersPage(driver);
    }
    private void setzipcodes(){
        zipcodes.put("97074", "Würzburg");
        zipcodes.put("97491", "Aidhausen");
        zipcodes.put("97488", "Stadtlauringen");
        zipcodes.put("28195", "Bremen");
        zipcodes.put("28197", "Bremen");
        zipcodes.put("28199", "Bremen");
        zipcodes.put("28201", "Bremen");
        zipcodes.put("28203", "Bremen");
        zipcodes.put("27568", "Bremerhaven");
        zipcodes.put("27570", "Bremerhaven");
        zipcodes.put("27572", "Bremerhaven");
        zipcodes.put("27574", "Bremerhaven");
        zipcodes.put("27576", "Bremerhaven");
        zipcodes.put("27578", "Bremerhaven");
        zipcodes.put("27580", "Bremerhaven");
    }

    public String getZipCode(int index) {
        return (String) zipcodes.keySet().toArray()[index];
    }
    
    public String getCity(String zipcode){
        return zipcodes.get(zipcode);
    }
}
