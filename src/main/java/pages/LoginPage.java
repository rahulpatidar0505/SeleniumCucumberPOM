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
	WebElement lc_signInLink;

	@FindBy(xpath = "//input[@id='email']")
	WebElement lc_email;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement lc_password;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement lc_signInButton;

	@FindBy(css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement lc_errorMsg;

	public void clickOnSignInLink() {
		lc_signInLink.click();
	}

	public void enterUserName(String emailId) {
		lc_email.sendKeys(emailId);
	}

	public void enterPassword(String password) {
		lc_password.sendKeys(password);
	}

	public void clickOnLoginButton() {
		lc_signInButton.click();
	}

	public void loginToApplication(String emailId, String passowrd) {
		clickOnSignInLink();
		enterUserName(emailId);
		enterPassword(passowrd);
		lc_signInButton.click();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String verifyErrorMsg() {
		return lc_errorMsg.getText();
	}

//	Faker faker = new Faker();
}
