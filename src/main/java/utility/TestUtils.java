package utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils extends BaseClass {
    public static Map<String, String> productDetails = new HashMap<>();
    public static String orderNumber;

    public void waitForElementPresent(WebElement element) {
        for (int i = 0; i < TimeUtil.DEFAULT_TIME_OUT; i++) {
            try {
                new WebDriverWait(driver, Duration.ofMillis(TimeUtil.DEFAULT_TIME_OUT))
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
    }

    public void clickElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);

    }

    public void scrollIntoView(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
