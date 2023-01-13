package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.AccountPage;
import pages.LoginPage;
import utility.TestConstant;
import utility.TestUtils;

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

    @And("^user verify \"([^\"]*)\" product name$")
    public void user_verify_product_name(String productName) {
        if (productName.equalsIgnoreCase(TestConstant.montana_jacket_details[0])) {
            Assert.assertEquals(TestConstant.montana_jacket_details[0], accountPage.getMontanaProductName());
        } else if (productName.equalsIgnoreCase(TestConstant.lando_jacket_details[0])) {
            Assert.assertEquals(TestConstant.lando_jacket_details[0], accountPage.getLandoProductName());
        } else {
            Assert.assertEquals(TestConstant.zeppelin_pant_details[0], accountPage.getZeppelinProductName());
        }
    }

    @And("^user verify \"([^\"]*)\" product price$")
    public void user_verify_product_price(String productName) {
        String product_price;
        if (productName.equalsIgnoreCase(TestConstant.montana_jacket_details[0])) {
            Assert.assertEquals(TestConstant.montana_jacket_details[3], accountPage.getMontanaProductPrice());
        } else if (productName.equalsIgnoreCase(TestConstant.lando_jacket_details[0])) {
            Assert.assertEquals(TestConstant.lando_jacket_details[3], accountPage.getLandoProductPrice());
        } else {
            Assert.assertEquals(TestConstant.zeppelin_pant_details[3], accountPage.getZeppelinProductPrice());
        }
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

    @Then("^verify product \"([^\"]*)\" is added into cart$")
    public void verify_product_is_added_into_cart(String productName) {
        if (productName.equalsIgnoreCase(TestConstant.montana_jacket_details[0])) {
            Assert.assertEquals(accountPage.getProductAddedMsg(),
                    "You added Montana Wind Jacket to your shopping cart.");
        } else if (productName.equalsIgnoreCase(TestConstant.lando_jacket_details[0])) {
            Assert.assertEquals(accountPage.getProductAddedMsg(),
                    "You added Lando Gym Jacket to your shopping cart.");
        } else {
            Assert.assertEquals(accountPage.getProductAddedMsg(),
                    "You added Zeppelin Yoga Pant to your shopping cart.");
        }
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
