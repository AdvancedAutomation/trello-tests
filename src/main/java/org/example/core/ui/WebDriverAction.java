package org.example.core.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class with common actions to execute.
 */
public class WebDriverAction {
    private static final Logger LOGGER = LogManager.getLogger(WebDriverAction.class.getName());

    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor.
     *
     * @param driver WebDriver
     * @param wait   WebDriverWait
     */
    public WebDriverAction(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    /**
     * wait and set a value.
     *
     * @param element webElement
     * @param value   text
     */
    public void setValue(final WebElement element, final String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Scroll to web element.
     *
     * @param element to scroll to
     */
    public void scrollToElement(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Click event with explicit wait for click.
     *
     * @param element to click.
     */
    public void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }

    public void jsClick(final WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    /**
     * Click event with By.
     *
     * @param locator Input By.
     */
    public void click(final By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Method for wait visibility of an element.
     *
     * @param element Input WebElement.
     */
    public void waitVisibility(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method for wait visibility of an element.
     *
     * @param element Input By locator.
     */
    public void waitVisibility(final By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    /**
     * element stale .
     *
     * @param element input .
     */
    public void staleElement(final WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Method for wait Presence of an element.
     *
     * @param element Input By locator.
     * @return Web Element.
     */
    public WebElement waitPresenceOfElement(final By element) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    /**
     * Method for return text By element.
     *
     * @param element By type.
     * @return the value of String type.
     */
    public String getValue(final By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    /**
     * Method for verify Exist WebElement.
     *
     * @param element By type.
     * @return boolean if exist element.
     */
    public boolean isExistingSelector(final By element) {
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            LOGGER.warn("Method: isExistingSelectorBy -> FALSE");
            return false;
        }
        return true;
    }

    /**
     * this element make to pause.
     */
    public void pause() {
        final int time = 500;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            LOGGER.error("Error in the sleep: ", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This element make to pause.
     *
     * @param timeOut Input time to wait.
     */
    public void pause(final int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            LOGGER.error("Error in the sleep: ", e);
            Thread.currentThread().interrupt();
        }
    }
}
