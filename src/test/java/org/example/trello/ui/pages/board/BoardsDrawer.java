package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * Page object of the Boards Drawer side bar page from Trello.
 */
public class BoardsDrawer extends AbstractPage {

    private static final String CSS_BOARD_LINK = "a[title='%s']";

    @FindBy(css = "a.quiet-button.js-add-board")
    private WebElement btnCreateNewBoard;

    @FindBy(css = "a.quiet-button.js-pin")
    private WebElement btnAlwaysKeepThisMenuOpen;

    @FindBy(css = "a.quiet-button.js-unpin")
    private WebElement btnDontKeepThisMenuOpen;

    @FindBy(css = "a.quiet-button.js-open-closed-boards")
    private WebElement btnSeeClosedBoards;

    private By label = By.cssSelector(".big-message.quiet");

    /**
     * Method for select a board.
     *
     * @param titleBoard input String.
     * @return the PO of Selected Board.
     */
    public SelectedBoard clickBoardInBoardsDrawer(final String titleBoard) {
        By boardLocator = By.cssSelector(String.format(CSS_BOARD_LINK, titleBoard));
        action.waitVisibility(boardLocator);
        action.click(boardLocator);
        return new SelectedBoard();
    }

    /**
     * Method Is Displayed Board.
     *
     * @param titleBoard String.
     * @return boolean is displayed.
     */
    public boolean doIsExistBoard(final String titleBoard) {
        By element = By.xpath(String.format(CSS_BOARD_LINK, titleBoard));
        return action.isExistingSelector(element);
    }

    /**
     * Method Is obtein Board.
     *
     * @return String is displayed.
     */
    public String getTitle() {
        return action.getValue(label);
    }
}
