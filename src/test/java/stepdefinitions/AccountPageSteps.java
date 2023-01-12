package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
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

	@And("user fetch first product name")
	public String user_fetch_first_product_name() {
		return accountPage.getMontanaProductName();
	}

	@And("user fetch first product price")
	public String user_fetch_first_product_price() {
		return accountPage.getMontanaProductPrice();
	}

	@And("user fetch second product name")
	public String user_fetch_second_product_name() {
		return accountPage.getLandoProductName();
	}

	@And("user fetch second product price")
	public String user_fetch_second_product_price() {
		return accountPage.getLandoProductPrice();
	}

	@And("user fetch third product name")
	public String user_fetch_third_product_name() {
		return accountPage.getZeppelinProductName();
	}

	@And("user fetch third product price")
	public String user_fetch_third_product_price() {
		return accountPage.getZeppelinProductPrice();
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

	@Then("verify product is added into cart")
	public void verify_product_is_added_into_cart() {

	}

	@Then("user navigate and hover to Men>Bottoms and click on Pants")
	public void user_navigate_and_hover_to_men_bottoms_and_click_on_pants() {
		accountPage.selectPant();
	}

	@Then("user click on cart link")
	public void user_click_on_cart_link() {
		accountPage.clickOnCart();
	}

	@Then("user click on proceed to checkout button")
	public void user_click_on_proceed_to_checkout_button() {
		accountPage.proceedToCheckout();
	}
}
