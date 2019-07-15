package org.fundacionjala.core.ui;

import org.fundacionjala.core.ui.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent of Page Objects.
 */
public abstract class AbstractPage {

    private static final int TIME_OUT_IN_SECONDS = 30;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    @FindBy(css = ".window-overlay .window")
    protected WebElement windowOverlay;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.action = new WebDriverAction(driver, wait);
        PageFactory.initElements(this.driver, this);
    }
}
