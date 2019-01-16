package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent the page object Close Board Wraper.
 */
public class CloseBoardWraper extends AbstractPage {

    /**
     * Find span.
     */
    @FindBy(css = "a.quiet.js-delete")
    private WebElement linkPermanentlyDeleteBoard;

    @FindBy(css = "a.js-reopen")
    private WebElement linkReOpen;

    @FindBy(css = "input.js-confirm.full.negate")
    private WebElement buttonConfirmDelete;

    /**
     * Method for select link Permanently Delete Board in the object page CloseBoardWraper.     *
     */
    public void selectPermanentlyCloseBoard() {
        action.waitVisibility(linkPermanentlyDeleteBoard);
        action.click(linkPermanentlyDeleteBoard);
        action.waitVisibility(buttonConfirmDelete);
        action.click(buttonConfirmDelete);
        By boardNotFoundMessage = By.xpath("//*[contains(text(),\"Board not found\")]");
        action.waitVisibility(boardNotFoundMessage);
    }
}

