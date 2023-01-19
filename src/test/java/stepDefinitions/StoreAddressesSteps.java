package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.StoreAddressesPage;
import page.StoreLoginPage;
import page.StoreNewAddressesPage;

import java.time.Duration;

public class StoreAddressesSteps  {

    private static WebDriver driver;

    private StoreAddressesPage addressesPage;

    @Given("User is logged in to CodersLab shop")
    public void user_is_logged_in_to_coders_lab_shop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        StoreLoginPage loginPage = new StoreLoginPage(driver);
        loginPage.loginAs("joesmith@gmail.com", "hardpass");

    }

    @When("User goes to addresses page")
    public void user_goes_to_addresses_page() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        addressesPage = new StoreAddressesPage(driver);

    }

    @And("User adds new address")
    public void user_adds_new_address() {
        addressesPage.addNewAddressBtn();

    }

    @And("User enters new address details alias {string}, address {string}, zip or postal code {string}, city {string}, country {string}, phone number {string}")
    public void user_enters_new_address_details_alias_address_zip_postal_code_city_country_phone_number(String alias, String address, String postcode, String city, String country, String phone) {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=address");
        StoreNewAddressesPage newAddressesPage = new StoreNewAddressesPage(driver);
        newAddressesPage.addNewAddress(alias, address, postcode, city, country, phone);

    }

    @Then("User can see new address")
    public void user_can_see_new_address() {
        addressesPage.isAddressVisible();

    }

    @And("User can verify created address alias {string}, address {string}, zip or postal code {string}, city {string}, country {string}, phone number {string}")
    public void user_can_verify_created_address_alias_address_zip_postal_code_city_country_phone(String alias, String address, String postcode, String city, String country, String phone) {
        addressesPage.verifyUserAddressDetails(alias, address, postcode, city, country, phone);

    }

    @And("User closes browser")
    public void user_closes_browser() {
            driver.quit();
        }

}
