package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement locator_signInLink;

	@FindBy(xpath = "//input[@id='email']")
	WebElement locator_email;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement locator_password;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement locator_signInButton;

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement locator_incorrectCaptcha;

	public void clickOnSignInLink() {
		locator_signInLink.click();
	}

	public void enterUserName(String emailId) {
		locator_email.sendKeys(emailId);
	}

	public void enterPassword(String passowrd) {
		locator_password.sendKeys(passowrd);
	}

	public void clickOnLogin() {
		locator_signInButton.click();
	}

	public void doLogin(String emailId, String passowrd) {
		clickOnSignInLink();
		enterUserName(emailId);
		enterPassword(passowrd);
		locator_signInButton.click();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String verifyErrorMsg() {
		return locator_incorrectCaptcha.getText();
	}
}
