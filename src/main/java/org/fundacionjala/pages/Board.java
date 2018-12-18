package org.fundacionjala.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class board.
 */
public class Board extends AbstractPage {
    @FindBy(className = "list-name-input")
    private WebElement listName;

    @FindBy(className = "mod-list-add-button")
    private WebElement buttonAddList;

    @FindBy(className = "js-add-a-card")
    private WebElement buttonAddCard;

    /**
     * Method to add a new list into board.
     *
     * @param name type String
     */
    public void addList(final String name) {
        action.setValue(listName, name);
        action.click(buttonAddList);
    }

    /**
     * Method to verify if is possible click on button add card.
     */
    public void canAddCard() {
        action.click(buttonAddCard);
    }
}
