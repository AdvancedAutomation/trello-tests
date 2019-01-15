package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.common.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page object of the Navigator page of Trello.
 */
public class Navigator extends AbstractPage {

    /**
     * All WebElements are identified by @FindBy annotation.
     */
    @FindBy(css = "a[href='/login?returnUrl=%2F']")
    private WebElement linkInit;

    @FindBy(css = ".header-logo-default")
    private WebElement trelloHeaderIcon;

    @FindBy(xpath = "//div[contains(@class,\"section-header\")]/ancestor::div[contains(@class,\"tab__tabSection\")]")
    private WebElement teamSection;

    /**
     * Method for go to the initial link.
     *
     * @return the PO of Login.
     */
    public Login clickInitLink() {
        action.click(linkInit);
        return new Login();
    }

    /**
     * Method to go to the main page.
     */
    public void goToMainPage() {
        driver.navigate().to("https://trello.com");
    }


    public List<WebElement> getAllTeams() {
        action.waitVisibility(teamSection);
        By teamItemsSection = By.xpath("//*[contains(@data-test-id,\"home-team-tab-section\")]");
        return teamSection.findElements(teamItemsSection);
    }
}
