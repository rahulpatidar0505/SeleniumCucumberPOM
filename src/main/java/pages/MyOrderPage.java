package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.ElementUtil;
import java.util.List;

public class MyOrderPage {
    private WebDriver driver;
    ElementUtil eleUtils = new ElementUtil(driver);
    public MyOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public @FindBy(xpath = "//a[normalize-space()='My Orders']")
    WebElement lc_myOrder;
    @FindBy(xpath = "//table[@id=\"my-orders-table\"]//tr")
    List<WebElement> orderRowList;

    public void goToMyOrders() {
        eleUtils.waitForElementPresent(lc_myOrder);
        eleUtils.doClick(lc_myOrder);
    }

    public String verifyOrderFromOrderTable() {
        String beforeXpath = "//table[@id=\"my-orders-table\"]//tr[";
        String afterXpath = "]/td[1]";
        String orderNumberFromOrderTable = null;
        for (int i = 1; i <= orderRowList.size(); i++) {
            String finalXpath = beforeXpath + i + afterXpath;
            orderNumberFromOrderTable = DriverFactory.getDriver().findElement(By.xpath(finalXpath)).getText();
            break;
        }
        return orderNumberFromOrderTable;
    }
}
