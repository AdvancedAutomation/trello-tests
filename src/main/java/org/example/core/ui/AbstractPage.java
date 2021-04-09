package org.example.core.ui;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.example.core.Environment;
import org.example.core.ui.driver.DriverFactory;

/**
 * Parent of Page Objects.
 */
public abstract class AbstractPage {

    private static final int TIME_OUT_IN_SECONDS = 30;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    /**
     * Constructor of class.
     */
    protected AbstractPage() {
        this.driver = DriverFactory.getDriver();
        if (Environment.getInstance().isMobile()) {
            final int width = 375;
            final int height = 812;
            driver.manage().window().setSize(new Dimension(width, height));
        } else {
            driver.manage().window().maximize();
        }
        this.wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        this.action = new WebDriverAction(driver, wait);
        PageFactory.initElements(this.driver, this);
    }
}
