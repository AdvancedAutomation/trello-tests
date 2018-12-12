package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the TeamCreation page from Trello.
 */
public class TeamCreation extends AbstractPage {

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-members")
    private WebElement tabMenbers;

    @FindBy(css = "input.autocomplete-input")
    private WebElement userNameTextField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement buttonInvited;

    /**
     * Method for add a members.
     *
     */
    public void addMembers() {
        action.click(tabMenbers);
    }
}
