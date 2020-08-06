package pages;

import base.BasePage;
import base.VisibleAjaxElementFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class OffersPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "nx-heading--page")
    private WebElement pageHeadline;

    @FindBy(how = How.CSS, using = "input[name='coverage']")
    private WebElement insuredSumField;

    @FindBy(how = How.CSS, using = "nx-dropdown[name='payment_schedule']")
    private WebElement paymentFrequencyDropdownField;

    @FindBy(how = How.CSS, using = "nx-dropdown[name='retention']")
    private WebElement deductibleDropdownField;

    @FindBy(how = How.CSS, using = "nx-dropdown[name='contract_term']")
    private WebElement contractDurationDropdownField;


    @FindBy(how = How.TAG_NAME, using = "nxt-comparison-table-header-cell")
    private List<WebElement> planCards;

    private final By dropdownList = By.className("nx-dropdown__panel-body");

    @FindBy(how = How.CSS, using = "nxt-comparison-table-row.table-footer button")
    private List<WebElement> insurancePlanOptions;

    @FindBy(how = How.CSS, using = "div[nxttoolbarright]")
    private WebElement totalTextInNavigation;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/div/div/div/h3")
    private WebElement totalTextInSummary;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[2]/nx-formfield/div/div/div/div")
    private WebElement fahrradPlusDropdownField;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/button")
    private WebElement fahrradPlusButton;

    @FindBy(how = How.XPATH,
            using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[1]/nx-card/div/div[3]/h3")
    private WebElement fahrradPlusAmountText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/button")
    private WebElement fensterPlusButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[2]/nx-card/div/div[3]/h3")
    private WebElement fensterPlusAmountText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/button")
    private WebElement houseProtectionButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[3]/nx-card/div/div[3]/h3")
    private WebElement houseProtectionAmountText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/button")
    private WebElement internetProtectionButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/div[2]/div/module-options/div/div/nxt-option-card[4]/nx-card/div/div[3]/h3")
    private WebElement internetProtectionAmountText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[3]/div/nxt-confirmation-layout-footer/button[1]")
    private WebElement continueApplicationButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/page-offer/div/module-basket/nxt-confirmation-layout/div/div[2]/div/div/div[1]/div/div[1]/p")
    private WebElement deductibleTextInSummary;

    private HashMap<String, String> paymentFrequencies = new HashMap<String, String>();
    private HashMap<String, String> deductibles = new HashMap<String, String>();

    public OffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);

        setTestFields.put("total", "0,00");

        setPaymentFrequenciesTestValues();
        setDeductiblesTestValues();
    }

    private void setDeductiblesTestValues(){
        deductibles.put("150 €","150,00 €");
        deductibles.put("300 €","300,00 €");
        deductibles.put("500 €","500,00 €");
    }

    private void setPaymentFrequenciesTestValues(){
        paymentFrequencies.put("monatlich","Monat");
        paymentFrequencies.put("vierteljährlich","Quartal");
        paymentFrequencies.put("halbjährlich","Halbjahr");
        paymentFrequencies.put("jährlich","Jahr");
    }

    private WebElement findDropdownListElement() {
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
        return paymentFrequencies.get(PaymentFrequency);
    }

    public String getPlanCardText(int planIndex){
        return planCards.get(planIndex).findElement(By.tagName("p")).getText();
    }

    public String getTotalFromSummary(){
        return totalTextInSummary.getText();
    }

    public String getTotalFromNavigation(){
        return totalTextInNavigation.getText();
    }


    public String getDeductibleInSummaryText(){
        return deductibleTextInSummary.getText();
    }

    public String setDeductibleDropdownField(int deductibleDropdownOption) {
        deductibleDropdownField.click();
        String deductible = clickDropDownItemByIndex(deductibleDropdownOption, deductibleDropdownField);
        return getDeductibleTestText(deductible);
    }

    private String getDeductibleTestText(String deductible){
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

        insurancePlanOptions.get(insurancePlanIndex).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        appendToTotal(getPlanCardText(insurancePlanIndex));
    }

    public String setFahrradPlusDropdownField(int fahrradPlusDropdownItemIndex) {
        fahrradPlusDropdownField.click();
        return clickDropDownItemByIndex(fahrradPlusDropdownItemIndex, fahrradPlusDropdownField);
    }

    public void clickFahrradPlusButton() {
        fahrradPlusButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appendToTotal(fahrradPlusAmountText.getText());
    }

    public void clickFensterPlusButton() {
        fensterPlusButton.click();
        appendToTotal(fensterPlusAmountText.getText());
    }

    public void clickHouseProtectionButton() {
        houseProtectionButton.click();
        appendToTotal(houseProtectionAmountText.getText());
    }

    public void clickInternetProtectionButton() {
        internetProtectionButton.click();
        appendToTotal(internetProtectionAmountText.getText());
    }

    public FileApplicationPage clickContinueApplicationButton() {
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
