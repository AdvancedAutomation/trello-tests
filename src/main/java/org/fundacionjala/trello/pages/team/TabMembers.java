package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    /**
     * Method for to do click a Invided button.
     * @param value type string.
     */
    public void clickInviteButton(final String value) {
        action.setValue(userNameTextField, value);
        action.click(selectFirstUser);
        action.click(buttonInvited);
    }

    /**
     * Method for get String of XPath.
     * @param accountKey type string.
     * @return type String.
     */
    public String getMemberAccount(final String accountKey) {
        By member = By.xpath(String.format("//*[contains(text(), '@%s')]", accountKey));
        return action.getValue(member);
    }
}
