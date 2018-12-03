package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Boards extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'quiet-button js-add-board')]")
    WebElement linkCreateNewTablero;


    @FindBy(className = "header-btn-text")
    WebElement btnTableros;

    public BoardCreation clickAddBoard() {
        action.click(btnTableros);
        action.click(linkCreateNewTablero);
        return new BoardCreation();
    }
}
