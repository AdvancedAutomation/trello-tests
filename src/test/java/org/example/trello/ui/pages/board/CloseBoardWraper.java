package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

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

    @FindBy(css = ".js-confirm")
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

