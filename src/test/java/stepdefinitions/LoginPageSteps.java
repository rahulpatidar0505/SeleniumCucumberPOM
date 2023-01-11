package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	@Given("user is on home page")
	public void user_is_on_home_page() {
		DriverFactory.getDriver()
				.get("https://magento.softwaretestingboard.com/");
	}

	@When("user click on signin link")
	public void user_is_on_login_page() {
		loginPage.clickOnSignInLink();
	}

	@And("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@And("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.clickOnLogin();
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
}
