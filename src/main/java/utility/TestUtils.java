package utility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils extends BaseClass {

	public static void selectByVisibleText(WebElement element, int timeout, String visibleText) {
		waitForElementPresent(element, timeout);
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	public static WebElement waitForElementPresent(WebElement element, int timeout) {
		for (int i = 0; i < timeout; i++) {
			try {
				new WebDriverWait(driver, Duration.ofMillis(timeout))
						.until(ExpectedConditions.presenceOfElementLocated((By) element));
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}
		}
		return element;
	}
	public static void staleElementRefExceptionSolution(WebElement element) {

		for (int i = 0; i <= 3; i++) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void clickElementByJS(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}
	public static void scrollIntoView(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
