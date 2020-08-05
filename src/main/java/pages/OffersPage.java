package pages;

import base.BasePage;
import base.VisibleAjaxElementFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class OffersPage extends BasePage {
//    private final By pageHeadline = By.className("nx-heading--page");
    @FindBy(how = How.CLASS_NAME, using = "nx-heading--page")
    private WebElement pageHeadline;

//    private final By insuredSumField = By.cssSelector("input[name='coverage']");
    @FindBy(how = How.CSS, using = "input[name='coverage']")
    private WebElement insuredSumField;

//    private final By paymentFrequencyDropdownField = By.cssSelector("nx-dropdown[name='payment_schedule']");
    @FindBy(how =How.CSS, using = "nx-dropdown[name='payment_schedule']")
    private WebElement paymentFrequencyDropdownField;

//    private final By deductibleDropdownField = By.cssSelector("nx-dropdown[name='retention']");
    @FindBy(how = How.CSS, using = "nx-dropdown[name='retention']")
    private WebElement deductibleDropdownField;

//    private final By contractDurationDropdownField = By.cssSelector("nx-dropdown[name='contract_term']");
    @FindBy(how = How.CSS, using = "nx-dropdown[name='contract_term']")
    private WebElement contractDurationDropdownField;


//    private final By planCards = By.tagName("nxt-comparison-table-header-cell");
    @FindBy(how = How.TAG_NAME, using = "nxt-comparison-table-header-cell")
    private List<WebElement> planCards;

    private final By dropdownList = By.className("nx-dropdown__panel-body");
//    @FindBy(how = How.CLASS_NAME, using = "nx-dropdown__panel-body")
//    private WebElement dropdownList;

//    private final By totalTextInNavigation = By.cssSelector("div[nxttoolbarright]");
    @FindBy(how = How.CSS, using = "div[nxttoolbarright]")
    private WebElement totalTextInNavigation;

//    private final By totalTextInSummary = By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/div/div/div/h3");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/div/div/div/h3")
    private WebElement totalTextInSummary;

//    private final By fahrradPlusDropdownField = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[2]/nx-formfield/div/div/div/div");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[2]/nx-formfield/div/div/div/div")
    private WebElement fahrradPlusDropdownField;

//    private final By fahrradPlusButton = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/button");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/button")
    private WebElement fahrradPlusButton;

//    private final By fahrradPlusAmountText = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/h3");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/h3")
    private WebElement fahrradPlusAmountText;

//    private final By fensterPlusButton = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/button");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/button")
    private WebElement fensterPlusButton;

//    private final By fensterPlusAmountText = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/h3");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/h3")
    private WebElement fensterPlusAmountText;

//    private final By houseProtectionButton = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/button");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/button")
    private WebElement houseProtectionButton;

//    private final By houseProtectionAmountText = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/h3");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/h3")
    private WebElement houseProtectionAmountText;

//    private final By internetProtectionButton = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/button");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/button")
    private WebElement internetProtectionButton;

//    private final By internetProtectionAmountText = By.xpath("//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/h3");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/h3")
    private WebElement internetProtectionAmountText;

//    private final By continueApplicationButton = By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/button[1]");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/button[1]")
    private WebElement continueApplicationButton;

//    private final By deductibleTextInSummary = By.xpath("//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[2]/div/div/div[1]/div/div[1]/p");
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[2]/div/div/div[1]/div/div[1]/p")
    private WebElement deductibleTextInSummary;

    public OffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
        setTestFields.put("total", "0,00");
    }

    private WebElement findDropdownListElement() {
//        waitForElementToBeClickable(dropdownList);
        return driver.findElement(dropdownList);
    }

    private String clickDropDownItemByIndex(int dropdownElementIndex, WebElement dropdownField) {
        List<WebElement> dropDownElements = findDropdownListElement()
                .findElements(By.cssSelector("nx-dropdown-item[role='option']"));

        dropDownElements.get(dropdownElementIndex).click();
        return getSelectedDropDownOptionText(dropdownField);
    }

    private String getSelectedDropDownOptionText(WebElement dropdownField) {
        return dropdownField.findElement(By.cssSelector("nx-dropdown span.ng-star-inserted")).getText();
    }

    public String getHeadlineText() {
        return pageHeadline.getText();
    }

    public String setPaymentFrequencyDropdownField(int paymentFrequencyDropdownOption) {
        paymentFrequencyDropdownField.click();
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
//        waitForElementToBeClickable(By.cssSelector(planCards.toString().split(" ")[1] +" p"));
        return planCards.get(planIndex).findElement(By.tagName("p")).getText();
    }

    public String getTotalFromSummary(){
//        waitForElementToBeClickable(totalTextInSummary);
        return totalTextInSummary.getText();
    }

    public String getTotalFromNavigation(){
//        waitForElementToBeClickable(totalTextInNavigation);
        return totalTextInNavigation.getText();
    }


    public String getDeductibleInSummaryText(){
//        waitForElementToBeClickable(deductibleTextInSummary);
        return deductibleTextInSummary.getText();
    }

    public String setDeductibleDropdownField(int deductibleDropdownOption) {
        deductibleDropdownField.click();
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
        contractDurationDropdownField.click();
        return clickDropDownItemByIndex(durationDropdownOption, contractDurationDropdownField);
    }

    public void setInsuredSumField(String insuredSum) {
        insuredSumField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), insuredSum);
    }

    public String getInsuredSumField() {
        return insuredSumField.getAttribute("value");
    }

    public void clickInsurancePlan(int insurancePlanIndex) {
        List<WebElement> tableRowElements = driver.findElements(By.cssSelector("div.c-comparison-table__leftcolumn"));
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, tableRowElements.get(5));

        waitForElementToBeClickable(driver.findElement(By.cssSelector("nxt-comparison-table-row.table-footer button")));

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
        fahrradPlusDropdownField.click();
        return clickDropDownItemByIndex(fahrradPlusDropdown, fahrradPlusDropdownField);
    }

    public void clickFahrradPlusButton() {
        fahrradPlusButton.click();
//        waitForElementToBeClickable(fahrradPlusAmountText);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appendToTotal(fahrradPlusAmountText.getText());
    }

    public void clickFensterPlusButton() {
//        waitForElementToBeClickable(fensterPlusButton);
        fensterPlusButton.click();
//        waitForElementToBeClickable(fensterPlusButton);
        appendToTotal(fensterPlusAmountText.getText());
    }

    public void clickHouseProtectionButton() {
//        waitForElementToBeClickable(houseProtectionButton);
        houseProtectionButton.click();
//        waitForElementToBeClickable(houseProtectionButton);
        appendToTotal(houseProtectionAmountText.getText());
    }

    public void clickInternetProtectionButton() {
//        waitForElementToBeClickable(internetProtectionButton);
        internetProtectionButton.click();
//        waitForElementToBeClickable(internetProtectionButton);
        appendToTotal(internetProtectionAmountText.getText());
    }

    public FileApplicationPage clickContinueApplicationButton() {
//        waitForElementToBeClickable(continueApplicationButton);
        continueApplicationButton.click();
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
