package pages;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utility.TestUtils;
import java.util.List;

public class AccountPage {
	private WebDriver driver;
	String productName;
	String productPrice;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//span[normalize-space()='Men']")
	WebElement lc_men;

	@FindBy(xpath = "//a[contains(@href,'tops-men.html')]//span[contains(text(),'Tops')]")
	WebElement lc_tops;

	@FindBy(xpath = "//a[contains(@href,'jackets-men.html')]//span[contains(text(),'Jackets')]")
	WebElement lc_jackets;

	@FindBy(xpath = "//a[contains(@href,'bottoms-men.html')]//span[contains(text(),'Bottoms')]")
	WebElement lc_bottoms;

	@FindBy(xpath = "//a[contains(@href,'pants-men.html')]//span[contains(text(),'Pants')]")
	WebElement lc_pants;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement lc_productAddedMsg;

	@FindBy(css = ".product.name.product-item-name")
	List<WebElement> lc_productList;

	@FindBy(xpath = "//div[@class='swatch-option text'][@role='option']")
	List<WebElement> lc_productSizeList;

	@FindBy(xpath = "//div[@class='swatch-option color']")
	List<WebElement> lc_productColorList;

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	public
	WebElement lc_addToCartButton;

	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement lc_cartLink;

	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
	WebElement lc_checkout;

	@FindBy(xpath = "//span[contains(text(),'Montana Wind Jacket')]")
	WebElement lc_montanaProductName;
	@FindBy(xpath = "//h1[@class = 'page-title']//span[@itemprop=\"name\"]")
	WebElement lc_productName;

	@FindBy(xpath = "//div[contains(@class,'product-info-price')]//span[contains(@id,'product-price')]//span[@class='price']")
	WebElement lc_productPrice;

	Actions action=new Actions(DriverFactory.getDriver());
	public void selectJacket() {
		action.moveToElement(lc_men).build().perform();
		TestUtils.scrollIntoView(lc_tops, driver);
		TestUtils.clickElementByJS(lc_jackets, driver);
	}

	public void selectPant() {
		action.moveToElement(lc_men).build().perform();
		TestUtils.scrollIntoView(lc_bottoms, driver);
		TestUtils.clickElementByJS(lc_pants, driver);
	}
	public void selectProductName(String productName) {
		for (WebElement product : lc_productList) {
			if (product.getText().contains(productName)) {
				product.click();
				break;
			}
		}
	}
	public String getProductName() {
		productName =  lc_productName.getText();
		return productName;
	}

	public String getProductPrice() {
		productPrice =  lc_productPrice.getText();
		return productPrice;
	}
	public String getProductAddedMsg() {
		TestUtils.waitForElementPresent(lc_productAddedMsg, 5);
		return lc_productAddedMsg.getText();
	}
	public void selectProductSize(String productSize) {
		for (WebElement size : lc_productSizeList) {
			if (size.getText().contains(productSize)) {
				size.click();
				break;
			}
		}
	}
	public void selectProductColor(String productColor) {
		for (WebElement color : lc_productColorList) {
			if (color.getAttribute("aria-label").contains(productColor)) {
				color.click();
				break;
			}
		}
	}

	public void clickOnAddToCartButton() {
		TestUtils.waitForElementPresent(lc_addToCartButton, 5);
		TestUtils.clickOn(driver, lc_addToCartButton, 2);
	}

	public void clickOnCart(){
		TestUtils.waitForElementPresent(lc_cartLink, 5);
		TestUtils.clickOn(driver, lc_cartLink, 2);
	}
	public void proceedToCheckout(){
		TestUtils.waitForElementPresent(lc_checkout, 5);
		TestUtils.clickOn(driver, lc_checkout, 2);
	}

	public void selectProductAndCheckout(String productName, String productSize, String productColor){
		selectProductName(productName);
		selectProductSize(productSize);
		selectProductColor(productColor);
		clickOnAddToCartButton();
		clickOnCart();
		proceedToCheckout();
	}
}

