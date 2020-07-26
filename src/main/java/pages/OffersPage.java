package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class OffersPage {
    private final WebDriver driver;
    private final By pageHeadline = By.className("nx-heading--page");
    private final By insuredSumField = By.cssSelector("input[name='coverage']");
    private final By paymentFrequencyDropdownField = By.cssSelector("nx-dropdown[name='payment_schedule']");
    private final By deductibleDropdownField = By.cssSelector("nx-dropdown[name='retention']");

    private void clickDropDownField(By dropdownField){
        driver.findElement(dropdownField).click();
    }
    private WebElement findDropdownListElement(){
        return driver.findElement(By.className("nx-dropdown__panel-body"));
    }

    private String clickDropDownItemByIndex(int dropdownElementIndex, By dropdownField){
        List<WebElement> dropDownElements = findDropdownListElement()
                .findElements(By.cssSelector("nx-dropdown-item[role='option']"));

        dropDownElements.get(dropdownElementIndex).click();
        return getSelectedDropDownOptionText(dropdownField);
    }

    private String getSelectedDropDownOptionText(By dropdownField){
        return driver.findElement(dropdownField)
                .findElement(By.cssSelector("nx-dropdown span.ng-star-inserted")).getText();
    }

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    public String getHeadlineText(){
        return driver.findElement(pageHeadline).getText();
    }

    public String setPaymentFrequencyDropdownField(int paymentFrequency){
        clickDropDownField(paymentFrequencyDropdownField);
        return  clickDropDownItemByIndex(paymentFrequency, paymentFrequencyDropdownField);
    }

    public String setDeductibleDropdownField(int deductible){
        clickDropDownField(deductibleDropdownField);
        return  clickDropDownItemByIndex(deductible, deductibleDropdownField);
    }

    public void setInsuredSumField(String insuredSum){
        driver.findElement(insuredSumField).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), insuredSum);
    }


}
