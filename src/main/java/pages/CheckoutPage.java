package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ElementUtil;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    ElementUtil eleUtils = new ElementUtil(driver);

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='title']")
    WebElement lc_orderSummary;

    @FindBy(css = ".shipping-address-item.selected-item")
    WebElement lc_selectShippingAddress;
    @FindBy(css = "input[value='flatrate_flatrate']")
    WebElement lc_selectShippingMethod;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    WebElement lc_nextButton;

    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    WebElement lc_placeOrderButton;

    public @FindBy(xpath = "//span[contains(normalize-space(),'Thank you for your purchase!')]")
    WebElement lc_thanksMsg;

    public @FindBy(xpath = "//main[@id='maincontent']//p[1]")
    WebElement lc_orderNumber;

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    WebElement lc_accountPanelArrow;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
    WebElement lc_myAccount;

    public @FindBy(xpath = "//div[@aria-expanded='false']//strong")
    List<WebElement> lc_productDisplayList;

    public @FindBy(xpath = "//div[@class='content minicart-items' and @aria-hidden='false']")
    WebElement lc_displayProductSummary;

    public @FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Montana Wind Jacket')]")
    WebElement lc_montana_product_name;

    public @FindBy(xpath = "//strong[normalize-space()='Montana Wind Jacket']/parent::div/following-sibling::div[@class='subtotal']")
    WebElement lc_montana_product_price;

    @FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Lando Gym Jacket')]")
    WebElement lc_landoProductName;

    @FindBy(xpath = "//strong[normalize-space()='Lando Gym Jacket']/parent::div/following-sibling::div[@class='subtotal']")
    WebElement lc_landoProductPrice;

    @FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Zeppelin Yoga Pant')]")
    WebElement lc_zeppelinProductName;

    @FindBy(xpath = "//strong[normalize-space()='Zeppelin Yoga Pant']/parent::div/following-sibling::div[@class='subtotal']")
    WebElement lc_zeppelinProductPrice;

    public String getMontanaProductName() {
        eleUtils.waitForElementPresent(lc_montana_product_name);
        return eleUtils.doGetElementText(lc_montana_product_name);
    }

    public String getMontanaProductPrice() {
        eleUtils.waitForElementPresent(lc_montana_product_price);
        return eleUtils.doGetElementText(lc_montana_product_price);
    }

    public String getLandoProductName() {
        return eleUtils.doGetElementText(lc_landoProductName);
    }

    public String getLandoProductPrice() {
        return eleUtils.doGetElementText(lc_landoProductPrice);
    }

    public String getZeppelinProductName() {
        return eleUtils.doGetElementText(lc_zeppelinProductName);
    }

    public String getZeppelinProductPrice() {
        return eleUtils.doGetElementText(lc_zeppelinProductPrice);
    }

    public String getCheckoutPageTitle() {
        return driver.getTitle();
    }

    public void expandOrderSummary() {
        eleUtils.waitForElementPresent(lc_orderSummary);
        eleUtils.doClick(lc_orderSummary);
        eleUtils.waitForElementPresent(lc_displayProductSummary);
    }

    public void verifyShippingAddressIsSelected() {
        eleUtils.waitForElementPresent(lc_selectShippingAddress);
        eleUtils.doIsDisplayed(lc_selectShippingAddress);
    }

    public void verifyShippingMethodIsSelected() {
        eleUtils.waitForElementPresent(lc_selectShippingMethod);
        eleUtils.doIsDisplayed(lc_selectShippingMethod);
    }

    public void clickOnNext() {
        eleUtils.waitForElementPresent(lc_nextButton);
        eleUtils.doClick(lc_nextButton);
    }

    public void clickOnPlaceOrder() {
        eleUtils.waitForElementPresent(lc_placeOrderButton);
        eleUtils.clickElementByJS(lc_placeOrderButton, driver);
    }

    public String fetchOrderNumber() {
        String orderNumberMessage = lc_orderNumber.getText();
        int colonIndex = orderNumberMessage.indexOf(':');
        String orderNumber = orderNumberMessage.substring(colonIndex + 2);
        return orderNumber.replace(".", "");
    }

    public String getThanksMessage() {
        eleUtils.waitForElementPresent(lc_thanksMsg);
        return lc_thanksMsg.getText();
    }

    public void goToMyAccount() {
        eleUtils.waitForElementPresent(lc_accountPanelArrow);
        eleUtils.doClick(lc_accountPanelArrow);
        eleUtils.doClick(lc_myAccount);
    }

    public void navigateToCheckout() {
        driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");
    }
}
