package org.fundacionjala.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
     * Method for close the driver.
     */
    public void closeDriver() {
        driver.close();
    }
}
