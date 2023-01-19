package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreCartPage {

    @FindBy(css = "a[class='btn btn-primary']")
    private WebElement storeProceedToCheckoutBtn;

    public StoreCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutBtn() {
        storeProceedToCheckoutBtn.click();
    }

}
