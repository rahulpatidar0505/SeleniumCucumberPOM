package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.BaseClass;
import utility.TestUtils;

import java.util.List;

public class CheckoutPage extends BaseClass {
	private WebDriver driver;

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
		TestUtils.waitForElementPresent(lc_montana_product_name, 5);
		return lc_montana_product_name.getText();
	}
	public String getMontanaProductPrice() {
		TestUtils.waitForElementPresent(lc_montana_product_price, 5);
		return lc_montana_product_price.getText();
	}
	public String getLandoProductName() {
		return lc_landoProductName.getText();
	}
	public String getLandoProductPrice() {
		return lc_landoProductPrice.getText();
	}
	public String getZeppelinProductName() {
		return lc_zeppelinProductName.getText();
	}
	public String getZeppelinProductPrice() {
		return lc_zeppelinProductPrice.getText();
	}
	public String getCheckoutPageTitle(){
		return driver.getTitle();
	}
	public void expandOrderSummary(){
		TestUtils.waitForElementPresent(lc_orderSummary, 5);
		clickOn(driver, lc_orderSummary, 2);
		TestUtils.waitForElementPresent(lc_displayProductSummary, 20);
	}
	public void verifyShippingAddressIsSelected(){
		TestUtils.waitForElementPresent(lc_selectShippingAddress, 5);
		lc_selectShippingAddress.isSelected();
	}

	public void verifyShippingMethodIsSelected(){
		TestUtils.waitForElementPresent(lc_selectShippingMethod, 5);
		lc_selectShippingMethod.isSelected();
	}
	public void clickOnNext(){
		TestUtils.waitForElementPresent(lc_nextButton, 5);
		clickOn(driver, lc_nextButton, 2);
	}
	public void clickOnPlaceOrder(){
		TestUtils.waitForElementPresent(lc_placeOrderButton, 10);
		TestUtils.clickElementByJS(lc_placeOrderButton, driver);
	}
	public String fetchOrderNumber(){
		String orderNumberMessage = lc_orderNumber.getText();
		int colonIndex = orderNumberMessage.indexOf(':');
		String orderNumber = orderNumberMessage.substring(colonIndex + 2);
		return orderNumber.replace(".", "");
	}
	public String getThanksMessage(){
		TestUtils.waitForElementPresent(lc_thanksMsg, 10);
		return lc_thanksMsg.getText();
	}
	public void goToMyAccount(){
		TestUtils.waitForElementPresent(lc_accountPanelArrow, 5);
		clickOn(driver, lc_accountPanelArrow, 2);
		clickOn(driver, lc_myAccount, 2);
	}
	public void navigateToCheckout() {
		driver.navigate().to("https://magento.softwaretestingboard.com/checkout/#shipping");
	}
}
