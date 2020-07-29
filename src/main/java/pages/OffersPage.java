package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class OffersPage extends BasePage {
    private final By pageHeadline = By.className("nx-heading--page");
    private final By insuredSumField = By.cssSelector("input[name='coverage']");
    private final By paymentFrequencyDropdownField = By.cssSelector("nx-dropdown[name='payment_schedule']");
    private final By deductibleDropdownField = By.cssSelector("nx-dropdown[name='retention']");
    private final By contractDurationDropdownField = By.cssSelector("nx-dropdown[name='contract_term']");
    private final By planCards = By.tagName("nxt-comparison-table-header-cell");
    private final By dropdownList = By.className("nx-dropdown__panel-body");
    private final By totalTextInNavigation = By.cssSelector("div[nxttoolbarright]");
    private final By totalTextInSummary =
            By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/div/div/div/h3");
    private final By fahrradPlusDropdownField =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[2]/nx-formfield/div/div/div/div");
    private final By fahrradPlusButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/button");
    private final By fahrradPlusAmountText =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/h3");
    private final By fensterPlusButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/button");
    private final By fensterPlusAmountText =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/h3");
    private final By houseProtectionButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/button");
    private final By houseProtectionAmountText =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/h3");
    private final By internetProtectionButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/button");
    private final By internetProtectionAmountText =
            By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/h3");
    private final By continueApplicationButton =
            By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/button[1]");
private final By deductibleTextInSummary =
            By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[2]/div/div/div[1]/div/div[1]/p");

    public OffersPage(WebDriver driver) {
        super(driver);
        setTestFields.put("total", "0,00");
    }

    private void clickDropDownField(By dropdownField) {
        waitForElementToBeClickable(dropdownField);
        driver.findElement(dropdownField).click();
    }

    private WebElement findDropdownListElement() {
        waitForElementToBeClickable(dropdownList);
        return driver.findElement(dropdownList);
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
        String paymentFrequency = clickDropDownItemByIndex(paymentFrequencyDropdownOption, paymentFrequencyDropdownField);
        return getPaymentFrequencyTestText(paymentFrequency);
    }

    private String getPaymentFrequencyTestText(String PaymentFrequency){
        HashMap<String, String> paymentFrequencies = new HashMap<String, String>();

        paymentFrequencies.put("monatlich","Monat");
        paymentFrequencies.put("vierteljährlich","Quartal");
        paymentFrequencies.put("halbjährlich","Halbjahr");
        paymentFrequencies.put("jährlich","Jahr");

        return paymentFrequencies.get(PaymentFrequency);
    }

    public String getPlanCardText(int planIndex){
        waitForElementToBeClickable(By.cssSelector(planCards.toString().split(" ")[1] +" p"));
        return driver.findElements(planCards).get(planIndex).findElement(By.tagName("p")).getText();
    }

    public String getTotalFromSummary(){
        waitForElementToBeClickable(totalTextInSummary);
        return driver.findElement(totalTextInSummary).getText();
    }

    public String getTotalFromNavigation(){
        waitForElementToBeClickable(totalTextInNavigation);
        return driver.findElement(totalTextInNavigation).getText();
    }


    public String getDeductibleInSummaryText(){
        waitForElementToBeClickable(deductibleTextInSummary);
        return driver.findElement(deductibleTextInSummary).getText();
    }

    public String setDeductibleDropdownField(int deductibleDropdownOption) {
        clickDropDownField(deductibleDropdownField);
        String deductible = clickDropDownItemByIndex(deductibleDropdownOption, deductibleDropdownField);
        return getDeductibleTestText(deductible);
    }

    private String getDeductibleTestText(String deductible){
        HashMap<String, String> deductibles = new HashMap<String, String>();

        deductibles.put("150 €","150");
        deductibles.put("300 €","300");
        deductibles.put("500 €","500");

        return deductibles.get(deductible);
    }

    public String setContractDurationDropdownField(int durationDropdownOption) {
        clickDropDownField(contractDurationDropdownField);
        return clickDropDownItemByIndex(durationDropdownOption, contractDurationDropdownField);
    }

    public void setInsuredSumField(String insuredSum) {
        driver.findElement(insuredSumField).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), insuredSum);
    }

    public String getInsuredSumField() {
        return driver.findElement(insuredSumField).getAttribute("value");
    }

    public void clickInsurancePlan(int insurancePlanIndex) {
        List<WebElement> tableRowElements = driver.findElements(By.cssSelector("div.c-comparison-table__leftcolumn"));
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, tableRowElements.get(5));

        waitForElementToBeClickable(By.cssSelector("nxt-comparison-table-row.table-footer button"));

        List<WebElement> insurancePlanOptions = driver.
                findElements(By.cssSelector("nxt-comparison-table-row.table-footer button"));
        insurancePlanOptions.get(insurancePlanIndex).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        appendToTotal(getPlanCardText(insurancePlanIndex));
    }

    public String setFahrradPlusDropdownField(int fahrradPlusDropdown) {
        waitForElementToBeClickable(fahrradPlusButton);
        clickDropDownField(fahrradPlusDropdownField);
        return clickDropDownItemByIndex(fahrradPlusDropdown, fahrradPlusDropdownField);
    }

    public void clickFahrradPlusButton() {
        driver.findElement(fahrradPlusButton).click();
        waitForElementToBeClickable(fahrradPlusAmountText);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appendToTotal(driver.findElement(fahrradPlusAmountText).getText());
    }

    public void clickFensterPlusButton() {
        waitForElementToBeClickable(fensterPlusButton);
        driver.findElement(fensterPlusButton).click();
        waitForElementToBeClickable(fensterPlusButton);
        appendToTotal(driver.findElement(fensterPlusAmountText).getText());
    }

    public void clickHouseProtectionButton() {
        waitForElementToBeClickable(houseProtectionButton);
        driver.findElement(houseProtectionButton).click();
        waitForElementToBeClickable(houseProtectionButton);
        appendToTotal(driver.findElement(houseProtectionAmountText).getText());
    }

    public void clickInternetProtectionButton() {
        waitForElementToBeClickable(internetProtectionButton);
        driver.findElement(internetProtectionButton).click();
        waitForElementToBeClickable(internetProtectionButton);
        appendToTotal(driver.findElement(internetProtectionAmountText).getText());
    }

    public FileApplicationPage clickContinueApplicationButton() {
        waitForElementToBeClickable(continueApplicationButton);
        driver.findElement(continueApplicationButton).click();
        return new FileApplicationPage(driver);
    }

    private void appendToTotal(String text){
        String amount = text.split("\\s+")[0];

        String totalText = setTestFields.get("total");
        try {
            BigDecimal total = parse(totalText, Locale.GERMAN).add(parse(amount, Locale.GERMAN));
            String updatedTotalText = NumberFormat.getNumberInstance(Locale.GERMAN).format(total);
            setTestFields.put("total",updatedTotalText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
