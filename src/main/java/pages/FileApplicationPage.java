package pages;

import base.BasePage;
import base.VisibleAjaxElementFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FileApplicationPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "nx-heading--page")
    private WebElement pageHeadline;

    @FindBy(how = How.CSS, using = "div[nxttoolbarright]")
    private WebElement totalTextInNavigation;

    @FindBy(how = How.CSS, using = "input[formcontrolname='birthdate']")
    private WebElement birthDateField;

    @FindBy(how = How.CSS, using = "input[formcontrolname='zipcode']")
    private WebElement zipCodeField;

    public FileApplicationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new VisibleAjaxElementFactory(driver, 10), this);
    }

    public String getHeadlineText() {
        return pageHeadline.getText();
    }

    public String getTotalFromNavigation(){
        return totalTextInNavigation.getText();
    }

    public String getBirthDateText(){
        return birthDateField.getAttribute("value");
    }

    public String getZipCodeText(){
        return zipCodeField.getAttribute("value");
    }

}
