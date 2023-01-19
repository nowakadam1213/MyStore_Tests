package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreNewAddressesPage {

    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement storeAliasInput;

    @FindBy(id = "field-address1")
    private WebElement storeAddress1Input;

    @FindBy(id = "field-postcode")
    private WebElement storePostcodeInput;

    @FindBy(id = "field-city")
    private WebElement storeCityInput;

    @FindBy(id = "field-id_country")
    private WebElement storeCountryInput;

    @FindBy(id = "field-phone")
    private WebElement storePhoneInput;

    @FindBy(css = ".btn.btn-primary.form-control-submit.float-xs-right")
    private WebElement saveAddressBtn;

    public StoreNewAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress(String alias, String address, String postcode, String city, String country, String phone) {
        storeAliasInput.clear();
        storeAliasInput.sendKeys(alias);

        storeAddress1Input.clear();
        storeAddress1Input.sendKeys(address);

        storePostcodeInput.clear();
        storePostcodeInput.sendKeys(postcode);

        storeCityInput.clear();
        storeCityInput.sendKeys(city);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=arguments[1]",storeCountryInput, country);

        storePhoneInput.clear();
        storePhoneInput.sendKeys(phone);

        saveAddressBtn.click();
    }

}
