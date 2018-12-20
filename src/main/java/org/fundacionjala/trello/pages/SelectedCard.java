package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a selected card page.
 */
public class SelectedCard extends AbstractPage {

    By cardName = By.cssSelector(".js-card-name");

    public String getValue() {
        return action.getValue(cardName);
    }
}
