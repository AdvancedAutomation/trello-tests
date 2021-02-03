package org.example.trello.ui.pages;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.common.Login;

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

    @FindBy(xpath = "//span[@class=\"icon-lg icon-member\"]/ancestor::div[contains(@class,\"mod-no-sidebar\")]")
    private WebElement boardSection;

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

    /**
     * This method goes to the page board of an specific user.
     *
     * @param user Input user.
     */
    public void goToPersonalPage(final String user) {
        By homeLeftSideBar = By.cssSelector(".home-left-sidebar-container");
        if (!action.isExistingSelector(homeLeftSideBar)) {
            driver.navigate().to("https://trello.com/" + user + "/boards");
        }
    }

    /**
     * This method extract the list of all the teams who are inside an specific the web element.
     *
     * @return List of Elements.
     */
    public List<WebElement> getAllTeams() {
        action.waitVisibility(teamSection);
        By teamItemsSection = By.xpath("//*[contains(@data-test-id,\"home-team-tab-section\")]");
        if (action.isExistingSelector(teamItemsSection)) {
            action.waitVisibility(teamItemsSection);
            return teamSection.findElements(teamItemsSection);
        }
        return Collections.emptyList();
    }

    /**
     * Method for get all board in a list.
     *
     * @return List of WebElements.
     */
    public List<WebElement> getAllBoards() {
        action.waitVisibility(boardSection);
        By boardsLocator = By.xpath("//*[@class=\"icon-lg icon-member\"]"
                .concat("/ancestor::div[contains(@class,\"mod-no-sidebar\")]")
                .concat("/descendant::a[contains(@class,\"board-tile\")]"));
        if (action.isExistingSelector(boardsLocator)) {
            action.waitVisibility(boardsLocator);
            return boardSection.findElements(boardsLocator);
        }
        return Collections.emptyList();
    }
}
