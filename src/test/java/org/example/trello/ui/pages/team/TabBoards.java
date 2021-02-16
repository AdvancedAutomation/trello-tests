package org.example.trello.ui.pages.team;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.board.BoardCreation;

/**
 * this class represent a team board.
 */
public class TabBoards extends AbstractPage {
    @FindBy(xpath = "//div[contains(@class,'tabbed-pane-main-col')]/descendant::*[@class='board-tile mod-add']")
    private WebElement createBoardButton;

    /**
     * Method for add a board.
     *
     * @return the PO of Board Creation.
     */
    public BoardCreation clickAddBoard() {
        action.waitVisibility(createBoardButton);
        action.click(createBoardButton);
        return new BoardCreation();
    }

}
