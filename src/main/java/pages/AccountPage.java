package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ElementUtil;
import java.util.List;

public class AccountPage {
    private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    ElementUtil eleUtils = new ElementUtil(driver);

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

    public void selectJacket() {
        eleUtils.moveToElement(lc_men, driver);
        eleUtils.scrollIntoView(lc_tops, driver);
        eleUtils.clickElementByJS(lc_jackets, driver);
    }

    public void selectPant() {
        eleUtils.moveToElement(lc_men, driver);
        eleUtils.scrollIntoView(lc_bottoms, driver);
        eleUtils.clickElementByJS(lc_pants, driver);
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
        return eleUtils.doGetElementText(lc_productName);
    }

    public String getProductPrice() {
        return eleUtils.doGetElementText(lc_productPrice);
    }

    public String getProductAddedMsg() {
        eleUtils.waitForElementPresent(lc_productAddedMsg);
        return eleUtils.doGetElementText(lc_productAddedMsg);
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
        eleUtils.waitForElementPresent(lc_addToCartButton);
        eleUtils.doClick(lc_addToCartButton);
    }

    public void clickOnCart() {
        eleUtils.waitForElementPresent(lc_cartLink);
        eleUtils.doClick(lc_cartLink);
    }

    public void proceedToCheckout() {
        eleUtils.waitForElementPresent(lc_checkout);
        eleUtils.doClick(lc_checkout);
    }
}

