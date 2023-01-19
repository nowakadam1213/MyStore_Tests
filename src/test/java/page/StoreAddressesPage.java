package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StoreAddressesPage {

    @FindBy(css = "a[data-link-action=\"add-address\"]")
    private WebElement addAddressBtn;

    @FindBy(className = "address-body")
    private WebElement addressDetails;

    public StoreAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addNewAddressBtn() {
        addAddressBtn.click();
    }

    public void isAddressVisible() {
        Assert.assertTrue("Address is not not displayed", addressDetails.isDisplayed());
        System.out.println("Address is displayed");

    }

    public void verifyUserAddressDetails(String alias, String address, String postcode, String city, String country, String phone) {
    String _alias = "Mr.";
    Assert.assertEquals("User alias is incorrect", alias, _alias);
    System.out.println("User alias is correct");
    String _address = "69 Test Rd";
    Assert.assertEquals("User address is incorrect", address, _address);
    System.out.println("User address is correct");
    String _postcode = "CL13 7AO";
    Assert.assertEquals("User zip/postal code incorrect", postcode, _postcode);
    System.out.println("User zip/postal code correct");
    String _city = "Testingham";
    Assert.assertEquals("User city is incorrect", city, _city);
    System.out.println("User city is correct");
    String _country = "17";
    Assert.assertEquals("User country is incorrect", country, _country);
    System.out.println("User country is correct");
    String _phone = "011 1111 1111";
    Assert.assertEquals("User phone number is incorrect", phone, _phone);
    System.out.println("User phone number is correct");

    }

}