package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ElementUtil;

public class LoginPage {
    private WebDriver driver;
    ElementUtil eleUtils = new ElementUtil(driver);

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

    @FindBy(xpath = "//div[@id='email-error']")
    WebElement lc_emailErrorMsg;

    public void clickOnSignInLink() {
        eleUtils.doClick(lc_signInLink);
    }

    public void enterUserName(String emailId) {
        eleUtils.doSendkeys(lc_email, emailId);
    }

    public void enterPassword(String password) {
        eleUtils.doSendkeys(lc_password, password);
    }

    public void clickOnLoginButton() {
        eleUtils.doClick(lc_signInButton);
    }

    public void loginToApplication(String emailId, String passowrd) {
        clickOnSignInLink();
        enterUserName(emailId);
        enterPassword(passowrd);
        lc_signInButton.click();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public String getLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    public String verifyErrorMsg() {
        return eleUtils.doGetElementText(lc_errorMsg);
    }

    public String verifyInvalidEmailErrorMsg() {
        return eleUtils.doGetElementText(lc_emailErrorMsg);
    }
}
