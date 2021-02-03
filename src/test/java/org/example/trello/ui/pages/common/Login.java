package org.example.trello.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.Navigator;
import org.example.trello.ui.pages.board.Boards;

/**
 * this class represented a login page.
 */
public class Login extends AbstractPage {

    private static final String CSS_PROFILE = "button[data-test-id='header-member-menu-button'] > div[title*='%s']";

    public Login() {
        super();
        driver.get("https://trello.com/login");
    }
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
        if (action.isExistingSelector(By.cssSelector(String.format(CSS_PROFILE, strUserName)))) {
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

