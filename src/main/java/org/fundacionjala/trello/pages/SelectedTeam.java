package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a selected card page.
 */
public class SelectedTeam extends AbstractPage {

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-members")
    private WebElement tabMenbers;

    /**
     * Method for add a members.
     * @return class TabMember.
     */
    public TabMembers openTabMembers() {
        action.click(tabMenbers);
        return new TabMembers();
    }

}
