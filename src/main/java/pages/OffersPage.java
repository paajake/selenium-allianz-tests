package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OffersPage {
    private final WebDriver driver;
    private final By pageHeadline = By.className("nx-heading--page");
    private final By insuredSumField = By.cssSelector("input[name='coverage']");
    private final By paymentFrequencyDropdownField = By.cssSelector("nx-dropdown[name='payment_schedule']");
    private final By deductibleDropdownField = By.cssSelector("nx-dropdown[name='retention']");
    private final By contractDurationDropdownField = By.cssSelector("nx-dropdown[name='contract_term']");
    private final By fahrradPlusDropdownField =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[2]/nx-formfield/div/div/div/div");
    private final By fahrradPlusButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/button");
    private final By fensterPlusButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/button");
    private final By houseProtectionButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/button");
    private final By internetProtectionButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/button");
    private final By continueApplicationButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/button[1]");

    public OffersPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickDropDownField(By dropdownField) {
        waitForElementToBeClickable(dropdownField);
        driver.findElement(dropdownField).click();
    }

    private WebElement findDropdownListElement() {
        return driver.findElement(By.className("nx-dropdown__panel-body"));
    }

    private String clickDropDownItemByIndex(int dropdownElementIndex, By dropdownField) {
        List<WebElement> dropDownElements = findDropdownListElement()
                .findElements(By.cssSelector("nx-dropdown-item[role='option']"));

        dropDownElements.get(dropdownElementIndex).click();
        return getSelectedDropDownOptionText(dropdownField);
    }

    private String getSelectedDropDownOptionText(By dropdownField) {
        return driver.findElement(dropdownField)
                .findElement(By.cssSelector("nx-dropdown span.ng-star-inserted")).getText();
    }

    public String getHeadlineText() {
        return driver.findElement(pageHeadline).getText();
    }

    public String setPaymentFrequencyDropdownField(int paymentFrequencyDropdownOption) {
        clickDropDownField(paymentFrequencyDropdownField);
        return clickDropDownItemByIndex(paymentFrequencyDropdownOption, paymentFrequencyDropdownField);
    }

    public String setDeductibleDropdownField(int deductibleDropdownOption) {
        clickDropDownField(deductibleDropdownField);
        return clickDropDownItemByIndex(deductibleDropdownOption, deductibleDropdownField);
    }

    public String setContractDurationDropdownField(int durationDropdownOption) {
        clickDropDownField(contractDurationDropdownField);
        return clickDropDownItemByIndex(durationDropdownOption, contractDurationDropdownField);
    }

    public void setInsuredSumField(String insuredSum) {
        driver.findElement(insuredSumField).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), insuredSum);
    }

    public void clickInsurancePlan(int insurancePlanIndex) {
        List<WebElement> tableRowElements = driver.findElements(By.cssSelector("div.c-comparison-table__leftcolumn"));
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, tableRowElements.get(4));


        List<WebElement> insurancePlanOptions = driver.
                findElements(By.cssSelector("nxt-comparison-table-row.table-footer button"));
        insurancePlanOptions.get(insurancePlanIndex).click();
    }

    public void clickFahrradPlusButton() {
        driver.findElement(fahrradPlusButton).click();
    }

    public String setFahrradPlusDropdownField(int fahrradPlusDropdown) {
        waitForElementToBeClickable(fahrradPlusButton);
        clickDropDownField(fahrradPlusDropdownField);
        return clickDropDownItemByIndex(fahrradPlusDropdown, fahrradPlusDropdownField);
    }

    public void clickFensterPlusButton() {
        waitForElementToBeClickable(fensterPlusButton);
        driver.findElement(fensterPlusButton).click();
    }

    public void clickHouseProtectionButton() {
        waitForElementToBeClickable(houseProtectionButton);
        driver.findElement(houseProtectionButton).click();
    }

    public void clickInternetProtectionButton() {
        waitForElementToBeClickable(internetProtectionButton);
        driver.findElement(internetProtectionButton).click();
    }

    public FileApplicationPage clickContinueApplicationButton() {
        waitForElementToBeClickable(continueApplicationButton);
        driver.findElement(continueApplicationButton).click();
        return new FileApplicationPage(driver);
    }

    private void waitForElementToBeClickable(By elementIdentifier) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(elementIdentifier)));
    }
}
