package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreOrderPage {

    @FindBy(name = "confirm-addresses")
    private WebElement storeConfirmAddressBtn;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement storeConfirmShippingMethodBtn;

    @FindBy(id = "payment-option-1")
    private WebElement storePayByCheckBtn;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement storeTermsOfServiceCheckbox;

    @FindBy(css = "button[class='btn btn-primary center-block']")
    private WebElement storePlaceOrderBtn;

    public StoreOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickConfirmAddressBtn() {
        storeConfirmAddressBtn.click();
    }

    public void clickConfirmShippingMethodBtn() {
        storeConfirmShippingMethodBtn.click();
    }

    public void selectPayByCheckBtn() {
        storePayByCheckBtn.click();
    }

    public void agreeToTermsOfServiceCheckbox() {
        storeTermsOfServiceCheckbox.click();
    }

    public void clickPlaceOrderBtn() {
        storePlaceOrderBtn.click();
    }

}
