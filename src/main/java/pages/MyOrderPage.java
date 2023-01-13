package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.BaseClass;
import utility.TestUtils;

import java.util.List;

public class MyOrderPage extends BaseClass {
	public MyOrderPage() {
	}
	public @FindBy(xpath = "//span[normalize-space()='My Orders']")
	WebElement locator_myOrderText;
	public @FindBy(xpath = "//a[normalize-space()='My Orders']")
	WebElement locator_myOrder;
	@FindBy(xpath = "//table[@id=\"my-orders-table\"]//tr")
	List<WebElement> orderRowList;

	public void goToMyOrders(){
		TestUtils.waitForElementPresent(locator_myOrder, 5);
		locator_myOrder.click();
	}

	public String verifyOrderFromOrderTable() {
		String beforeXpath="//table[@id=\"my-orders-table\"]//tr[";
		String afterXpath="]/td[1]";
		String orderNumberFromOrderTable = null;
		for (int i = 1; i <=orderRowList.size(); i++)
		{
			String finalXpath=beforeXpath+i+afterXpath;
			orderNumberFromOrderTable= DriverFactory.getDriver().findElement(By.xpath(finalXpath)).getText();
			break;
		}
		return orderNumberFromOrderTable;
	}
}
