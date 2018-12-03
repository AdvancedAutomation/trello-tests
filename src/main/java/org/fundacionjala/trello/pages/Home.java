package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    /**
     * All WebElements are identified by @FindBy annotation
     */
    @FindBy(linkText = "Log In")
    WebElement linkInit;

    public Home() {
        driver.get("https://trello.com/");
    }


    public Login clickInitLink() {
        action.click(linkInit);
        return new Login();
    }

    public void closeDriver() {
        driver.close();
    }
}
