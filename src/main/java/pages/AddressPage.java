package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.BaseClass;
import utility.TestUtils;

public class AddressPage extends BaseClass {
    private WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//strong[normalize-space()='Address Book']")
    WebElement lc_addressBook;

    @FindBy(xpath = "//div[@class='box box-billing-address']//span[contains(text(),'Edit Address')]")
    WebElement lc_editAddress;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement lc_firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lc_lastName;

    @FindBy(xpath = "//input[@name='company']")
    WebElement lc_company;

    @FindBy(xpath = "//input[@title='Street Address']")
    WebElement lc_streetAddress;

    @FindBy(xpath = "//input[@title=\"Street Address: Line 2\"]")
    WebElement lc_street_1;

    @FindBy(xpath = "//input[@name='city']")
    WebElement lc_city;

    @FindBy(xpath = "//select[@name='region_id']")
    WebElement lc_state;

    @FindBy(xpath = "//input[@name='postcode']")
    WebElement lc_postcode;

    @FindBy(xpath = "//select[@id='country']")
    WebElement lc_country;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement lc_phoneNumber;

    @FindBy(xpath = "//span[normalize-space()='Save Address']")
    WebElement lc_saveAddress;

    @FindBy(xpath = "//div[.='You saved the address.']")
    WebElement lc_successMsg;

    public String verifyAddressBookText() {
        return lc_addressBook.getText();
    }

    public void clickOnEditAddress() {
        lc_editAddress.click();
    }
    public void fillAddressDetails(String firstName, String lastName, String phoneNumber, String streetAddres,
                                   String country, String state, String city, String postcode) {
        sendkeys(driver, lc_firstName, 2, firstName);
        sendkeys(driver, lc_lastName, 2, lastName);
        sendkeys(driver, lc_phoneNumber, 2, phoneNumber);
        sendkeys(driver, lc_streetAddress, 2, streetAddres);
        TestUtils.selectByVisibleText(lc_country, 2, country);
        TestUtils.selectByVisibleText(lc_state, 2, state);
        sendkeys(driver, lc_city, 2, city);
        sendkeys(driver, lc_postcode, 2, postcode);
    }
    public void clickOnSaveAddressButton() {
        clickOn(driver, lc_saveAddress, 2);
    }

    public String verifyAddressSavedMessage() {
        return lc_successMsg.getText();
    }
}
