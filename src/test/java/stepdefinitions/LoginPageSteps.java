package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utility.TestConstant;
public class LoginPageSteps {

	private static String title;
	LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	@Given("user is on home page")
	public void user_is_on_home_page() {
		Assert.assertTrue(loginPage.getHomePageTitle().contains("Home Page"));
	}

	@And("user click on signin link")
	public void user_is_on_login_page() {
		loginPage.clickOnSignInLink();
	}

	@When("user enter valid username")
	public void user_enter_valid_username() {
		loginPage.enterUserName(TestConstant.EMAILID);
	}

	@And("user enter valid password")
	public void user_enter_valid_password() {
		loginPage.enterPassword(TestConstant.PASSWORD);
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
	}

	@And("page title should include {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
		String errorMsg = loginPage.verifyErrorMsg();
		Assert.assertEquals(errorMsg, "Incorrect CAPTCHA");
	}

	@And("user enter invalid username")
	public void userEnterInvalidUsername() {
		loginPage.enterUserName("random@gmail.com");
	}

	@And("user enter invalid password")
	public void userEnterInvalidPassword() {
		loginPage.enterPassword("random");
	}

	@Given("user is on login page")
	public void userIsOnLoginPage() {
		title = loginPage.getLoginPageTitle();
		Assert.assertTrue(title.contains("Customer Login"));	}

	@When("user enter invalid email")
	public void userEnterInvalidEmail() {
		loginPage.enterUserName("random");
	}

	@Then("verify the email error message")
	public void verifyTheEmailErrorMessage() {
		String errorMsg = loginPage.verifyInvalidEmailErrorMsg();
		Assert.assertTrue(errorMsg.contains("Please enter a valid email address"));
	}

	@And("verify title contains {string}")
	public void verifyTitleContains(String expectedTitle) {
		String loginTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginTitle.contains(expectedTitle));
	}

	@And("verify url contains {string}")
	public void verifyUrlContains(String expectedLoginUrl) {
		String loginUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(loginUrl.contains(expectedLoginUrl));
	}
}
