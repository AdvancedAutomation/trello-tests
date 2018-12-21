package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;

/**
 * this class represent a selected card page.
 */
public class SelectedCard extends AbstractPage {

    private By cardName = By.cssSelector(".js-card-name");

    /**
     * this method return value card.
     * @return type String.
     */
    public String getValue() {
        return action.getValue(cardName);
    }
}
