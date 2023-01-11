package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import pages.AccountPage;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {

	AccountPage accountPage = PageFactory.initElements(DriverFactory.getDriver(), AccountPage.class);
	LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String email = credList.get(0).get("email");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/");
		loginPage.doLogin(email, password);
	}

	@Given("user is on main page")
	public void user_is_on_main_page() {
		System.out.println("User is on home page");
	}

	@When("user navigate and hover to Men>Top and click on Jackets")
	public void user_navigate_and_hover_to_men_top_and_click_on_jackets() {
		accountPage.selectJacket();
	}

	@Then("user click on product {string}")
	public void user_click_on_product(String productName) {
		accountPage.selectProductName(productName);
	}

	@Then("user click on size {string}")
	public void user_click_on_size(String productSize) {
		accountPage.selectProductSize(productSize);
	}

	@Then("user click on color {string}")
	public void user_click_on_color(String productColor) {
		accountPage.selectProductColor(productColor);
	}

	@Then("user click on Add to cart button")
	public void user_click_on_add_to_cart_button() {
		accountPage.clickOnAddToCartButton();
	}

}
