package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class StorePurchaseSteps {

    private static WebDriver driver;

    private StoreProductPage productPage;

    private StoreOrderPage orderPage;

    @Given("User is logged in to MyStore shop")
    public void user_is_logged_in_to_MyStore_shop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        StoreLoginPage loginPage = new StoreLoginPage(driver);
        loginPage.loginAs("joesmith@gmail.com", "hardpass");

    }

    @When("User chooses product Hummingbird Printed Sweater")
    public void user_chooses_product_hummingbird_printed_sweater() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        StoreMainPage mainPage = new StoreMainPage(driver);
        mainPage.clickStoreProductBtn();
    }

    @And("User chooses product size {string}")
    public void user_chooses_product_size(String size) {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?id_product=1&id_product_attribute=3&rewrite=hummingbird-printed-t-shirt&controller=product#/2-size-m/8-color-white");
        productPage = new StoreProductPage(driver);
        productPage.changeSize(size);

    }
    @And("User adds {string} items")
    public void user_adds_items(String quantity) {
        productPage.changeQuantityOfProducts(quantity);

    }
    @And("User adds order to cart")
    public void user_adds_order_to_cart() {
        productPage.clickAddToCartBtn();

    }

    @And("User confirms cart contents")
    public void user_confirms_cart_contents() {
        productPage.clickProceedToCheckoutPopUpBtn();

    }

    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");
        StoreCartPage cartPage = new StoreCartPage(driver);
        cartPage.clickProceedToCheckoutBtn();
    }

    @And("User confirms address")
    public void user_confirms_address() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");
        orderPage = new StoreOrderPage(driver);
        orderPage.clickConfirmAddressBtn();
    }

    @And("User chooses shipping method")
    public void user_chooses_shipping_method() {
        orderPage.clickConfirmShippingMethodBtn();
    }

    @And("User chooses payment method")
    public void user_chooses_payment_method() {
        orderPage.selectPayByCheckBtn();
        orderPage.agreeToTermsOfServiceCheckbox();

    }
    @Then("User places order")
    public void user_places_order() {
        orderPage.clickPlaceOrderBtn();
    }

    @And("User takes a screenshot with order summary and total price")
    public void user_takes_a_screenshot_with_order_summary_and_total_price() {
        File scrFile = driver.findElement(By.id("order-confirmation")).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\Adam_Nowak\\MyStore_Tests\\screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("User closes store browser")
    public void user_closes_store_browser() {
        driver.quit();
    }

}


