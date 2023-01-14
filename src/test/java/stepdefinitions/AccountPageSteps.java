package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.AccountPage;
import pages.AddressPage;
import pages.LoginPage;
import utility.TestConstant;
import utility.TestUtils;
import java.util.List;
import java.util.Map;

public class AccountPageSteps {

    AccountPage accountPage = PageFactory.initElements(DriverFactory.getDriver(), AccountPage.class);
    LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
    AddressPage addressPage = PageFactory.initElements(DriverFactory.getDriver(), AddressPage.class);

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        String email = credList.get(0).get("email");
        String password = credList.get(0).get("password");
        DriverFactory.getDriver().get(TestConstant.URL);
        loginPage.loginToApplication(email, password);
    }

    @Given("user is on address page")
    public void user_is_on_address_page() {
        String addressBook = addressPage.verifyAddressBookText();
        Assert.assertEquals(addressBook, "Address Book");
    }

    @Then("user navigate and hover to Men>Top and click on Jackets")
    public void user_navigate_and_hover_to_men_top_and_click_on_jackets() {
        accountPage.selectJacket();
    }

    @And("user select product {string} and size {string} and color {string}")
    public void userSelectProductAndSizeAndColor(String productName, String productSize, String productColor) {
        accountPage.selectProductName(productName);
        accountPage.selectProductSize(productSize);
        accountPage.selectProductColor(productColor);

    }

    @Then("user click on Add to cart button")
    public void user_click_on_add_to_cart_button() {
        TestUtils.productDetails.put(accountPage.getProductName(), accountPage.getProductPrice());
        accountPage.clickOnAddToCartButton();
    }

    @Then("^verify product \"([^\"]*)\" is added into cart$")
    public void verify_product_is_added_into_cart(String productName) {
        if (productName.equalsIgnoreCase("Montana Wind Jacket")) {
            Assert.assertEquals(accountPage.getProductAddedMsg(),
                    "You added Montana Wind Jacket to your shopping cart.");
        } else if (productName.equalsIgnoreCase("Lando Gym Jacket")) {
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
