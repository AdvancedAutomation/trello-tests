package org.fundacionjala.core.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(css = ".window-overlay .window")
    protected WebElement windowOverlay;

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
