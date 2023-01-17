package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MyOrderPage;
import utility.TestUtils;

public class MyOrderPageSteps {

    MyOrderPage myOrderPage = PageFactory.initElements(DriverFactory.getDriver(), MyOrderPage.class);

    @And("^click on My Orders")
    public void click_on_My_Orders() {
        myOrderPage.goToMyOrders();
    }

    @And("^verify order number is present in order table$")
    public void verify_order_number_is_present_in_order_table() {
        String orderNumberFromOrderTable = myOrderPage.verifyOrderFromOrderTable();
        Assert.assertEquals(TestUtils.orderNumber, orderNumberFromOrderTable);
    }
}
