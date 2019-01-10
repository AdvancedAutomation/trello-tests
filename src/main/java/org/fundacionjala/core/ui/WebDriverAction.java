package org.fundacionjala.core.ui;

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
     * @param element webelement
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
     * Method for return text of css.
     *
     * @param cssField have be in format css String.
     * @return the text String.
     */
    public String getValue(final By cssField) {
        wait.until(ExpectedConditions.presenceOfElementLocated(cssField));
        return driver.findElement(cssField).getText();
    }

    /**
     * Method for return text of css.
     *
     * @param xpathField have be in format css String.
     * @return the text String.
     */
    public String getValueXPath(final By xpathField) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathField));
        return driver.findElement(xpathField).getText();
    }

    /**
     * Method for do click to XPath.
     *
     * @param xpathField have be in format css String.
     */
    public void clickXPath(final By xpathField) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpathField));
        driver.findElement(xpathField).click();
    }

    /**
     * Exist WebElement by cssSelector.
     *
     * @param element String Selector css.
     * @return boolean exist element.
     */
    public boolean existSelectorByCss(final String element) {
        try {
            driver.findElement(By.cssSelector(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Method to verify Exist XPath.
     *
     * @param element String Selector XPath.
     * @return boolean exist element.
     */
    public boolean existSelectorByXPath(final String element) {
        try {
            driver.findElement(By.xpath(element));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
