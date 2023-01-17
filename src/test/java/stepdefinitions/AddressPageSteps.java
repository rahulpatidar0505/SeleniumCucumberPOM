package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.AddressPage;
import pages.CheckoutPage;
import utility.ElementUtil;
import utility.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddressPageSteps {

    AddressPage addressPage = PageFactory.initElements(DriverFactory.getDriver(), AddressPage.class);
    CheckoutPage checkoutPage = PageFactory.initElements(DriverFactory.getDriver(), CheckoutPage.class);

    @When("user navigates to my account page")
    public void navigateToMyAccountPage() {
        checkoutPage.goToMyAccount();
    }

    @And("user click on edit address link")
    public void userClickOnEditAddressLink() {
        addressPage.clickOnEditAddress();
    }

    @And("user fills the form from sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_sheetname_and_rownumber(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData =
                reader.getData("ApplicationData/ApplicationData.xlsx", sheetName);

        String firstName = testData.get(rowNumber).get("firstName");
        String lastName = testData.get(rowNumber).get("lastName");
        String phoneNumber = testData.get(rowNumber).get("phoneNumber");
        String streetAddress = testData.get(rowNumber).get("streetAddress");
        String country = testData.get(rowNumber).get("country");
        String state = testData.get(rowNumber).get("state");
        String city = testData.get(rowNumber).get("city");
        String postcode = testData.get(rowNumber).get("postcode");

        addressPage.fillAddressDetails(firstName, lastName, phoneNumber, streetAddress, country, state, city, postcode);
    }

    @And("user clicks on save address button")
    public void clickSaveAddressButton() {
        addressPage.clickOnSaveAddressButton();
    }

    @Then("it shows a successful message {string}")
    public void verifySuccessMessage(String expectedMessage) {
        String successMessage = addressPage.verifyAddressSavedMessage();
        Assert.assertEquals(expectedMessage, successMessage);
    }
}
