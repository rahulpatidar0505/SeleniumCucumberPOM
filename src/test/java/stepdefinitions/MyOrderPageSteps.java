package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.MyOrderPage;

public class MyOrderPageSteps {

	MyOrderPage myOrderPage = PageFactory.initElements(DriverFactory.getDriver(), MyOrderPage.class);
	CheckoutPage checkoutPage= PageFactory.initElements(DriverFactory.getDriver(), CheckoutPage.class);

	@Then("^click on my order link")
	public void click_on_my_order_link() {
		myOrderPage.goToMyOrders();
	}

	@And("^verify order number is present in order table$")
	public void verify_order_number_is_present_in_order_table() throws Throwable {
		String orderNumber = checkoutPage.fetchOrderNumber();
		Assert.assertEquals(myOrderPage.verifySubmittedOrder(), orderNumber);
	}
}
