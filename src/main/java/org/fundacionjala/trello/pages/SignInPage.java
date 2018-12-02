package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Sign In Page.
 */
public class SignInPage extends AbstractPage {

    @FindBy(id = "credentials_username")
    private WebElement usernameTextBox;


    /**
     * Sets Email in the email text box.
     *
     * @param userEmail user name or email
     */
    public void setUsernameTextBox(final String userEmail) {
        action.setValue(usernameTextBox, userEmail);
    }

}
