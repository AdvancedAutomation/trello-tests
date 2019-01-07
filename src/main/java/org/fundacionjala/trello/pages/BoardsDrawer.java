package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Boards Drawer side bar page from Trello.
 */
public class BoardsDrawer extends AbstractPage {

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
     * @param titleBoard input String.
     * @return the PO of Selected Board.
     */
    public SelectedBoard clickBoardInBoardsDrawer(final String titleBoard) {
        WebElement board;
        board = driver.findElement(By.cssSelector(String.format(".js-all-boards span[title='%s']", titleBoard)));
        action.click(board);
        return new SelectedBoard();
    }

    /**
     * Method Is Displayed Board.
     * @param titleBoard String.
     * @return boolean is displayed.
     */
    public boolean doIsExistBoard(final String titleBoard) {
        String cssSelector = String.format(".js-all-boards span[title='%s']", titleBoard);
        return action.existSelectorByCss(cssSelector);
    }
}
