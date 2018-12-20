package org.fundacionjala.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of Page Objects.
 */
public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = DriverManager.getInstance().getWait();
        this.action = new WebDriverAction(driver, wait);
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Method for return text of css.
     * @param cssField have be in format css String.
     * @return the text String.
     */
    public String getValue(final String cssField) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssField)));
        return driver.findElement(By.cssSelector(cssField)).getText();
    }

    /**
     * Method for close the driver.
     */
    public void closeDriver() {
        driver.close();
    }
}
