package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.Navigator;
import org.fundacionjala.trello.pages.board.Boards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * this class represented a login page.
 */
public class Login extends AbstractPage {

    /**
     * Find user name text field of page.
     */
    @FindBy(name = "user")
    private WebElement userNameTextField;
    /**
     * find password text field of page.
     */
    @FindAll({
            @FindBy(name = "password"),
            @FindBy(css = "[name='password']")
    })
    private WebElement passwordTextField;
    /**
     * Find login button of page.
     */
    @FindBy(id = "login")
    private WebElement loginButton;

    /**
     * This method add one value of username text field .
     *
     * @param strUserName value of input.
     */
    protected void setUserNameTextField(final String strUserName) {
        action.waitVisibility(userNameTextField);
        action.setValue(userNameTextField, strUserName);
    }

    /**
     * This method add one value of password text field .
     *
     * @param strPassword value of input.
     */
    protected void setPasswordTextField(final String strPassword) {
        action.waitVisibility(passwordTextField);
        action.setValue(passwordTextField, strPassword);
    }

    /**
     * this method is for has been click in button.
     *
     * @return value of Boards type.
     */
    protected Boards clickLoginButton() {
        action.waitVisibility(loginButton);
        action.click(loginButton);
        return new Boards();
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     *
     * @param strUserName username value input.
     * @param strPasword  passwor value input.
     * @return value of board type.
     */
    public Boards loginAs(final String strUserName, final String strPasword) {
        By loggedIcon = By.xpath(String.format("//*[@class=\"member-initials\" and contains(@title,\"%s\")]",
                strUserName));
        if (action.isExistingSelector(loggedIcon)) {
            new Navigator().goToPersonalPage(strUserName);
        } else {
            //Fill user name
            this.setUserNameTextField(strUserName);
            //Fill passwordTextField
            this.setPasswordTextField(strPasword);
            //Click Login button
            return this.clickLoginButton();
        }
        return new Boards();
    }
}

