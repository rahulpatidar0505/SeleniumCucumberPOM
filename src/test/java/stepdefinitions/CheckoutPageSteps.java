package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.AccountPage;
import pages.CheckoutPage;
import utility.TestConstant;
import utility.TestUtils;

public class CheckoutPageSteps {

	CheckoutPage checkoutPage = PageFactory.initElements(DriverFactory.getDriver(), CheckoutPage.class);
	AccountPage accountPage = PageFactory.initElements(DriverFactory.getDriver(), AccountPage.class);

	@And("^verify user is on checkout page$")
	public void verify_user_is_on_checkout_page() {
		Assert.assertTrue(checkoutPage.getCheckoutPageTitle().contains("Checkout Magento Commerce"));
	}

	@When("^user expand order summary$")
	public void user_expand_order_summary() {
		if (checkoutPage.lc_productDisplayList.size() > 0) {
			checkoutPage.expandOrderSummary();
			Assert.assertTrue(checkoutPage.lc_displayProductSummary.isDisplayed());
		} else {
			Assert.assertTrue(checkoutPage.lc_displayProductSummary.isDisplayed());
		}
	}

	@Then("^verify selected product on the order summary$")
	public void verify_selected_product_on_the_order_summary() {
//		Assert.assertTrue(TestUtils.productDetails.containsKey(checkoutPage.getMontanaProductName()));
//		Assert.assertEquals(TestUtils.productDetails.get(checkoutPage.getMontanaProductName()),
//				checkoutPage.getMontanaProductPrice());

		Assert.assertEquals(checkoutPage.getMontanaProductName(), TestConstant.MONTANA_JACKET_NAME);
		Assert.assertEquals(checkoutPage.getMontanaProductPrice(), TestConstant.MONTANA_JACKET_PRICE);

//		Assert.assertTrue(TestUtils.productDetails.containsKey(checkoutPage.getLandoProductName()));
//		Assert.assertEquals(TestUtils.productDetails.get(checkoutPage.getLandoProductName()),
//				checkoutPage.getLandoProductPrice());

		Assert.assertEquals(checkoutPage.getLandoProductName(), TestConstant.LANDO_JACKET_NAME);
		Assert.assertEquals(checkoutPage.getLandoProductPrice(), TestConstant.LANDO_JACKET_PRICE);

//		Assert.assertTrue(TestUtils.productDetails.containsKey(checkoutPage.getZeppelinProductName()));
//		Assert.assertEquals(TestUtils.productDetails.get(checkoutPage.getZeppelinProductName()),
//				checkoutPage.getZeppelinProductPrice());

		Assert.assertEquals(checkoutPage.getZeppelinProductName(), TestConstant.ZEPPELIN_JACKET_NAME);
		Assert.assertEquals(checkoutPage.getZeppelinProductPrice(), TestConstant.ZEPPELIN_JACKET_PRICE);
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

	String orderNumber;

	@Then("^verify order is placed with thanks message and fetch order number$")
	public void verify_order_is_placed_with_thanks_message_and_fetch_order_number() {
		String thanksMessage = checkoutPage.getThanksMessage();
		orderNumber = checkoutPage.fetchOrderNumber();
		Assert.assertTrue(thanksMessage.contains("Thank you for your purchase"));
		Assert.assertFalse(orderNumber.isEmpty());
		TestUtils.orderNumber = orderNumber;
	}

	@Then("^click on My Account under user profile$")
	public void click_on_My_Account_under_user_profile() {
		checkoutPage.goToMyAccount();
	}

	@Given("user is on checkout page")
	public void userIsOnCheckoutPage() {
		Assert.assertTrue(checkoutPage.getCheckoutPageTitle().contains("Checkout Magento Commerce"));
	}

	@And("user navigate to checkout page")
	public void userNavigateToCheckoutPage() {
		checkoutPage.navigateToCheckout();
	}

	@Given("user is present on checkout page")
	public void userIsPresentOnCheckoutPage() {
		String checkoutPageTitle = checkoutPage.getCheckoutPageTitle();
		Assert.assertEquals(checkoutPageTitle, "Checkout Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites");
	}
}
