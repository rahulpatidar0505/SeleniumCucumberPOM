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
	CheckoutPageSteps checkoutPageSteps = new CheckoutPageSteps();
	@And("^click on My Orders")
	public void click_on_My_Orders() {
		myOrderPage.goToMyOrders();
	}

	@And("^verify order number is present in order table$")
	public void verify_order_number_is_present_in_order_table() {
		String orderNumber = checkoutPage.fetchOrderNumber();
		String orderNumberFromOrderTable = myOrderPage.verifyOrderFromOrderTable();
		Assert.assertEquals(orderNumberFromOrderTable, orderNumber);
	}
}
