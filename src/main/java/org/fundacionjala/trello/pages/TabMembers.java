package org.fundacionjala.trello.pages;

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
     * Method for to do click a Invided button.
     * @param accountKey type string.
     * @return type boolean.
     */
    public boolean existXPath(final String accountKey) {
        String xpath = String.format("//*[contains(text(), '@%s')]", accountKey);
        By value = By.xpath(xpath);
        return action.existXPath(value);
    }
}
