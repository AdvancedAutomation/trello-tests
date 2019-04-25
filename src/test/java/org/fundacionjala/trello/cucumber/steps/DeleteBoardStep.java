package org.fundacionjala.trello.cucumber.steps;


import cucumber.api.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import org.fundacionjala.trello.pages.board.CloseBoardWraper;
import org.fundacionjala.trello.pages.board.MenuBoard;
import org.fundacionjala.trello.pages.board.MenuMoreBoard;
import org.fundacionjala.trello.pages.board.SelectedBoard;

/**
 * Step definitions for Delete dashboard.
 */
public class DeleteBoardStep {

    @Autowired
    private SelectedBoard selectedBoard;

    @Autowired
    private MenuBoard menuBoard;

    @Autowired
    private MenuMoreBoard menuMoreBoard;

    @Autowired
    private CloseBoardWraper closeBoardWraper;

    /**
     * Close open board.
     */
    @And("I close Board")
    public void iCloseBoard() {
        selectedBoard.clickShowMenu();
        menuBoard.clickInLinkMore();
        menuMoreBoard.selectLinkCloseBoard();
    }

    /**
     * Delete close board.
     */
    @And("I delete Board")
    public void iDeleteBoard() {
        closeBoardWraper.selectPermanentlyCloseBoard();
    }
}
