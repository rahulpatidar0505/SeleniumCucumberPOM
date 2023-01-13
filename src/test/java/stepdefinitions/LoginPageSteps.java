package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestConstant;

public class LoginPageSteps {

	private static String title;
	LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver().get(TestConstant.URL);
	}

	@When("user click on signin link")
	public void user_is_on_login_page() {
		loginPage.clickOnSignInLink();
	}

	@And("user enter valid username")
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
		org.testng.Assert.assertEquals(errorMsg, "Incorrect CAPTCHA");
	}

	@And("user enter invalid username")
	public void userEnterInvalidUsername() {
		loginPage.enterUserName("random@gmail.com");
	}

	@And("user enter invalid password")
	public void userEnterInvalidPassword() {
		loginPage.enterPassword("random");
	}
}
