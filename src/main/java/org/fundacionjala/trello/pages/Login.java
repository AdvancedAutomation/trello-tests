package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Login extends AbstractPage {

    /**
     * All WebElements are identified by @FindBy annotation
     */
    @FindBy(name = "user")
    WebElement userNameTextField;

    @FindAll({
            @FindBy(name = "password"),
            @FindBy(css = "[name='password']")
    })
    WebElement passwordTextField;

    @FindBy(id = "login")
    WebElement loginButton;

    //Set user name in textbox
    public void setUserNameTextField(String strUserName) {
        action.setValue(userNameTextField, strUserName);
    }

    //Set passwordTextField in passwordTextField textbox
    public void setPasswordTextField(String strPassword) {
        action.setValue(passwordTextField, strPassword);
    }

    //Click on login button
    public Boards clickLoginButton() {
        action.click(loginButton);
        return new Boards();
    }


    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strUserName
     * @param strPasword
     * @return
     */
    public Boards loginAs(String strUserName, String strPasword) {
        //Fill user name
        this.setUserNameTextField(strUserName);
        //Fill passwordTextField
        this.setPasswordTextField(strPasword);
        //Click Login button
        return this.clickLoginButton();
    }
}

