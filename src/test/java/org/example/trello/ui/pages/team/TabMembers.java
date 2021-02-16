package org.example.trello.ui.pages.team;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * this class represent a selected card page.
 */
public class TabMembers extends AbstractPage {

    @FindBy(css = "div.full-name")
    private WebElement selectFirstUser;

    @FindBy(css = "input.autocomplete-input")
    private WebElement userNameTextField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement buttonInvited;

    @FindBy(css = "[class='option button-link remove-button']")
    private WebElement removeMemberButton;

    @FindBy(css = ".js-soft-remove")
    private WebElement softRemoveMember;

    /**
     * Method for to do click a Invided button.
     *
     * @param value type string.
     */
    public void clickInviteButton(final String value) {
        action.setValue(userNameTextField, value);
        action.click(selectFirstUser);
        action.click(buttonInvited);
    }

    /**
     * Method for get String of XPath.
     *
     * @param accountKey type string.
     * @return type String.
     */
    public String getMemberAccount(final String accountKey) {
        By member = By.xpath(String.format("//*[contains(text(), '@%s')]", accountKey));
        return action.getValue(member);
    }

    /**
     * Method of remove team member.
     *
     * @param memberName Input team member name.
     */
    public void deleteTeamMember(final String memberName) {
        action.waitVisibility(removeMemberButton);
        action.click(removeMemberButton);
        action.click(softRemoveMember);
    }
}
