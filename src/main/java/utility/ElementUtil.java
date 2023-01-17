package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementUtil {

    private WebDriver driver;
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void doSendkeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void doClick(WebElement element) {
        element.click();
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        waitForElementPresent(element);
        Select sel = new Select(element);
        sel.selectByVisibleText(visibleText);
    }

    public String doGetElementText(WebElement element) {
        return element.getText();
    }

    public void doIsDisplayed(WebElement element) {
        element.isDisplayed();
    }
    public void moveToElement(WebElement element, WebDriver driver) {
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public String waitForTitleIs(String titleVal, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleIs(titleVal))) {
            return driver.getTitle();
        } else {
            System.out.println("expected title is not visible...");
            return null;
        }
    }


    public String waitForUrlContains(String urlFractionValue, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.urlContains(urlFractionValue))) {
            return driver.getCurrentUrl();
        } else {
            System.out.println("expected url is not visible...");
            return null;
        }
    }

    public void staleElementRefExceptionSolution(WebElement element) {

        for (int i = 0; i <= 3; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementPresence(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

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
