package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: OR
//	private By emailId = By.id("email");
//	private By password = By.id("passwd");
//	private By signInButton = By.id("SubmitLogin");
//	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

//	public String getLoginPageTitle() {
//		return driver.getTitle();
//	}
//
//	public boolean isForgotPwdLinkExist() {
//		return driver.findElement(forgotPwdLink).isDisplayed();
//	}

//	public void enterUserName(String username) {
//		driver.findElement(emailId).sendKeys(username);
//	}
//
//	public void enterPassword(String pwd) {
//		driver.findElement(password).sendKeys(pwd);
//	}
//
//	public void clickOnLogin() {
//		driver.findElement(signInButton).click();
//	}


	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement locator_signInLink;

	@FindBy(xpath = "//input[@id='email']")
	WebElement locator_email;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement locator_password;

	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement locator_signInButton;

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

}
