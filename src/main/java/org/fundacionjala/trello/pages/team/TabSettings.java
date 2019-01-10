package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * PageObject of the Tab Settings inside of the Team page.
 */
public class TabSettings extends AbstractPage {
    @FindBy(css = "a[class='quiet-button']")
    private WebElement deleteButton;
    @FindBy(css = ".js-confirm")
    private WebElement confirmDeleteTeamButton;

    /**
     * Method for delete the team.
     */
    public void deleteTeam() {
        action.click(deleteButton);
        action.click(confirmDeleteTeamButton);
    }

}
