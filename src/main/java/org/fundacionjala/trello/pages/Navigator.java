package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.common.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    /**
     * Constructor of the page object of trello.
     */
    public Navigator() {
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

    /**
     * Method to go to the main page.
     */
    public void goMainPage() {
        action.click(trelloHeaderIcon);
    }
}
