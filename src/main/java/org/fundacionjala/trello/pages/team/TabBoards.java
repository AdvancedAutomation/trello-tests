package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.board.BoardCreation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a team board.
 */
public class TabBoards extends AbstractPage {

    @FindBy(xpath =
            "//div[@class='tabbed-pane-main-col-wrapper js-content']/descendant::*[@class='board-tile mod-add']")
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
