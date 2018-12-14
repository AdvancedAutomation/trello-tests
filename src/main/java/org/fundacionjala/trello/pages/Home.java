package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Home page of Trello.
 */
public class Home extends AbstractPage {

    /**
     * All WebElements are identified by @FindBy annotation.
     */
    //@FindBy(css = "a.global-header-section-button")
    @FindBy(css = "a[href='/login?returnUrl=%2F']")
    private WebElement linkInit;

    /**
     * Constructor of the page object of trello.
     */
    public Home() {
        driver.get("https://trello.com");
    }

    /**
     * Method for go to the initial link.
     *
     * @return the PO of Login.
     */
    public Login clickInitLink() {
        action.click(linkInit);
        return new Login();
    }
}
