package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreMainPage {

    @FindBy(xpath = "//a[normalize-space()='Hummingbird printed t-shirt']")
    private WebElement storeProductBtn;

    public StoreMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickStoreProductBtn() {
        storeProductBtn.click();
    }
}
