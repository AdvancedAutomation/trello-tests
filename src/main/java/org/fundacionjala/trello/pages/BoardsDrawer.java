package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.WebDriverAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Boards Drawer side bar page from Trello.
 */
public class BoardsDrawer {

    @FindBy(css = "a.quiet-button.js-add-board")
    private WebElement btnCreateNewBoard;

    @FindBy(css = "a.quiet-button.js-pin")
    private WebElement btnAlwaysKeepThisMenuOpen;

    @FindBy(css = "a.quiet-button.js-unpin")
    private WebElement btnDontKeepThisMenuOpen;

    @FindBy(css = "a.quiet-button.js-open-closed-boards")
    private WebElement btnSeeClosedBoards;

    /**
     * Method for select a board.
     *
     * @return the PO of Selected Board.
     */
    public SelectedBoard clickBoard(final String titleBoard) {
        WebElement board = "";
        WebDriverAction.click(board);
        return new SelectedBoard();
    }
}
