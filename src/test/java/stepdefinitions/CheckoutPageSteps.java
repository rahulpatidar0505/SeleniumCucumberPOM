package stepdefinitions;

import com.aventstack.extentreports.Status;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import utility.TestUtils;

public class CheckoutPageSteps {

	CheckoutPage checkoutPage= PageFactory.initElements(DriverFactory.getDriver(), CheckoutPage.class);
	AccountPageSteps accountPageSteps =  new AccountPageSteps();
	@Given("^user is on checkout page$")
	public void user_is_on_checkout_page() {
		System.out.println("user is on checkout page");
	}

	@When("^user expand order summary$")
	public void user_expand_order_summary() {
		if (checkoutPage.locator_productDisplayList.size() > 0) {
			checkoutPage.expandOrderSummary();
			TestUtils.waitForElementPresent(checkoutPage.locator_displayProductSummary, 5);
			Assert.assertTrue(checkoutPage.locator_displayProductSummary.isDisplayed());
		} else {
			TestUtils.waitForElementPresent(checkoutPage.locator_displayProductSummary, 5);
			Assert.assertTrue(checkoutPage.locator_displayProductSummary.isDisplayed());
		}
	}

	@Then("^verify selected product on the order summary$")
	public void verify_selected_product_on_the_order_summary() {
		Assert.assertEquals(accountPageSteps.user_fetch_first_product_name(), checkoutPage.getMontanaProductName());
		Assert.assertEquals(accountPageSteps.user_fetch_first_product_price(), checkoutPage.getMontanaProductPrice());

		Assert.assertEquals(accountPageSteps.user_fetch_second_product_name(), checkoutPage.getLandoProductName());
		Assert.assertEquals(accountPageSteps.user_fetch_second_product_price(), checkoutPage.getLandoProductPrice());

		Assert.assertEquals(accountPageSteps.user_fetch_third_product_name(), checkoutPage.getZeppelinProductName());
		Assert.assertEquals(accountPageSteps.user_fetch_third_product_price(), checkoutPage.getZeppelinProductPrice());
	}

	@And("^user verify shipping address is selected$")
	public void user_verify_shipping_address_is_selected() {
		checkoutPage.verifyShippingAddressIsSelected();
	}

	@And("^user verify shipping method is selected$")
	public void user_verify_shipping_method_is_selected() {
		checkoutPage.verifyShippingMethodIsSelected();
	}

	@Then("^user click on next button$")
	public void user_click_on_next_button() {
		checkoutPage.clickOnNext();
	}

	@Then("^user click on place order button$")
	public void user_click_on_place_order_button() {
		checkoutPage.clickOnPlaceOrder();
	}

	@Then("^verify order is placed with thanks message and fetch order number$")
	public void verify_order_is_placed_with_thanks_message_and_fetch_order_number() {
		String thanksMessage = checkoutPage.getThanksMessage();
		String orderNumber = checkoutPage.fetchOrderNumber();
		Assert.assertTrue(thanksMessage.contains("Thank you for your purchase"));
		Assert.assertFalse(orderNumber.isEmpty());
	}

	@Then("^click on My Account under user profile$")
	public void click_on_My_Account_under_user_profile() {
		checkoutPage.goToMyAccount();
	}
}
