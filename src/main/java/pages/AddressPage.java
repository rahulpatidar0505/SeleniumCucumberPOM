package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ElementUtil;

public class AddressPage {
    private WebDriver driver;
    ElementUtil eleUtils = new ElementUtil(driver);

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='box box-billing-address']//span[contains(text(),'Edit Address')]")
    WebElement lc_editAddress;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement lc_firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lc_lastName;

    @FindBy(xpath = "//input[@title='Street Address']")
    WebElement lc_streetAddress;

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

    public void clickOnEditAddress() {
        lc_editAddress.click();
    }

    public void fillAddressDetails(String firstName, String lastName, String phoneNumber, String streetAddres,
                                   String country, String state, String city, String postcode) {
        eleUtils.doSendkeys(lc_firstName, firstName);
        eleUtils.doSendkeys(lc_lastName, lastName);
        eleUtils.doSendkeys(lc_phoneNumber, phoneNumber);
        eleUtils.doSendkeys(lc_streetAddress, streetAddres);
        eleUtils.selectByVisibleText(lc_country, country);
        eleUtils.selectByVisibleText(lc_state, state);
        eleUtils.doSendkeys(lc_city, city);
        eleUtils.doSendkeys(lc_postcode, postcode);
    }

    public void clickOnSaveAddressButton() {
        eleUtils.doClick(lc_saveAddress);
    }

    public String verifyAddressSavedMessage() {
        return lc_successMsg.getText();
    }
}
