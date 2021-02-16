package org.example.trello.ui.pages.team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * this class represent a selected card page.
 */
public class SelectedTeam extends AbstractPage {

    @FindBy(css = ".js-org-members")
    private WebElement tabMembers;

    @FindBy(css = ".js-org-account")
    private WebElement tabSettings;

    private By cardName = By.cssSelector(".u-inline");

    /**
     * Method for add a members.
     *
     * @return class TabMember.
     */
    public TabMembers openTabMembers() {
        action.waitVisibility(tabMembers);
        action.click(tabMembers);
        return new TabMembers();
    }


    /**
     * Method for open tab setting.
     *
     * @return class TabSettings.
     */
    public TabSettings openTabSettings() {
        action.waitVisibility(tabSettings);
        action.click(tabSettings);
        action.pause();
        return new TabSettings();
    }

    /**
     * Method for return value.
     *
     * @return class TabMember.
     */
    public String getValue() {
        return action.getValue(cardName);
    }
}
