package org.fundacionjala.core.ui;

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

    /**
     * Method for wait visibility of an element.
     *
     * @param element Input WebElement.
     */
    public void waitVisibility(final WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
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
    public boolean existSelectorBy(final By element) {
        try {
            driver.findElement(element);
        } catch (NoSuchElementException e) {
            LOGGER.error("No such element: ", e);
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
        }
    }
}
