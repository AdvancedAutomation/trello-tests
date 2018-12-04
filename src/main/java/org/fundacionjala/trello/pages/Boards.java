package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Boards page from Trello.
 */
public class Boards extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'quiet-button js-add-board')]")
    private WebElement linkCreateNewTablero;


    @FindBy(className = "header-btn-text")
    private WebElement btnTableros;

    /**
     * Method for add a dashboard.
     *
     * @return the PO of Board Creation.
     */
    public BoardCreation clickAddBoard() {
        action.click(btnTableros);
        action.click(linkCreateNewTablero);
        return new BoardCreation();
    }
}
