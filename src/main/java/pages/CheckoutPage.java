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
	WebElement locator_orderSummary;

	@FindBy(css = ".shipping-address-item.selected-item")
	WebElement locator_selectShippingAddress;
	@FindBy(css = "input[value='flatrate_flatrate']")
	WebElement locator_selectShippingMethod;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	WebElement locator_nextButton;

	@FindBy(xpath = "//span[normalize-space()='Place Order']")
	WebElement locator_placeOrderButton;

	public @FindBy(xpath = "//span[contains(normalize-space(),'Thank you for your purchase!')]")
	WebElement locator_thanksMsg;

	public @FindBy(xpath = "//main[@id='maincontent']//p[1]")
	WebElement locator_orderNumber;

	@FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
	WebElement locator_accountPanelArrow;

	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='My Account']")
	WebElement locator_myAccount;

	public @FindBy(xpath = "//div[@aria-expanded='false']//strong")
	List<WebElement> locator_productDisplayList;
	
	public @FindBy(xpath = "//div[@class='content minicart-items' and @aria-hidden='false'] ")
	WebElement locator_displayProductSummary;

	public @FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Montana Wind Jacket')]")
	WebElement locator_montana_product_name;

	public @FindBy(xpath = "//strong[normalize-space()='Montana Wind Jacket']/parent::div/following-sibling::div[@class='subtotal']")
	WebElement locator_montana_product_price;

	@FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Lando Gym Jacket')]")
	WebElement locator_landoProductName;

	@FindBy(xpath = "//strong[normalize-space()='Lando Gym Jacket']/parent::div/following-sibling::div[@class='subtotal']")
	WebElement locator_landoProductPrice;

	@FindBy(xpath = "//strong[@class='product-item-name'][contains(text(),'Zeppelin Yoga Pant')]")
	WebElement locator_zeppelinProductName;

	@FindBy(xpath = "//strong[normalize-space()='Zeppelin Yoga Pant']/parent::div/following-sibling::div[@class='subtotal']")
	WebElement locator_zeppelinProductPrice;

	public String getMontanaProductName() {
		return locator_montana_product_name.getText();
	}
	public String getMontanaProductPrice() {
		return locator_montana_product_price.getText();
	}
	public String getLandoProductName() {
		return locator_landoProductName.getText();
	}
	public String getLandoProductPrice() {
		return locator_landoProductPrice.getText();
	}
	public String getZeppelinProductName() {
		return locator_zeppelinProductName.getText();
	}
	public String getZeppelinProductPrice() {
		return locator_zeppelinProductPrice.getText();
	}
	public void expandOrderSummary(){
		TestUtils.waitForElementPresent(locator_placeOrderButton, 5);
		clickOn(driver, locator_orderSummary, 2);
	}
	public void verifyShippingAddressIsSelected(){
		locator_selectShippingAddress.isSelected();
	}

	public void verifyShippingMethodIsSelected(){
		locator_selectShippingMethod.isSelected();
	}
	public void clickOnNext(){
		TestUtils.waitForElementPresent(locator_nextButton, 10);
		clickOn(driver, locator_nextButton, 2);
	}
	public void clickOnPlaceOrder(){
		TestUtils.waitForElementPresent(locator_placeOrderButton, 10);
		TestUtils.clickElementByJS(locator_placeOrderButton, driver);
	}
	public String fetchOrderNumber(){
		String orderNumberMessage = locator_orderNumber.getText();
		int colonIndex = orderNumberMessage.indexOf(':');
		String orderNumber = orderNumberMessage.substring(colonIndex + 2);
		return orderNumber.replace(".", "");
	}
	public String getThanksMessage(){
		TestUtils.waitForElementPresent(locator_thanksMsg, 10);
		return locator_thanksMsg.getText();
	}
	public void goToMyAccount(){
		TestUtils.waitForElementPresent(locator_accountPanelArrow, 5);
		clickOn(driver, locator_accountPanelArrow, 2);
		clickOn(driver, locator_myAccount, 2);
	}
}
