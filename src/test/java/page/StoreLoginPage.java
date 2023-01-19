package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreLoginPage {

    @FindBy(id = "field-email")
        private WebElement storeEmailInput;

        @FindBy(id = "field-password")
        private WebElement storePasswordInput;

        @FindBy(id = "submit-login")
        private WebElement storeSignInBtn;

        public StoreLoginPage(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public void loginAs(String email, String passwd) {
            storeEmailInput.clear();
            storeEmailInput.sendKeys(email);

            storePasswordInput.clear();
            storePasswordInput.sendKeys(passwd);

            storeSignInBtn.click();
        }

}

