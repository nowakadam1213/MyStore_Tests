package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StoreProductPage {

    @FindBy(id = "group_1")
    private WebElement storeProductSizeBtn;

    @FindBy(css = ".material-icons.touchspin-up")
    private WebElement storeQuantityAddBtn;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement storeAddToCartBtn;

    @FindBy(css = "a[class='btn btn-primary']")
    private WebElement storeProceedToCheckoutPopUpBtn;

    public StoreProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void changeSize(String size) {
        storeProductSizeBtn.sendKeys(size);
    }

    public void changeQuantityOfProducts(String quantity) {
        int q = Integer.parseInt(quantity);
        for (int i = 0; i < q - 1 ; i++){
            storeQuantityAddBtn.click();
        }
    }

    public void clickAddToCartBtn() {
        storeAddToCartBtn.click();
    }

    public void clickProceedToCheckoutPopUpBtn() {
        storeProceedToCheckoutPopUpBtn.click();
    }

}
