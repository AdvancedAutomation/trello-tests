package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent the page object MenuMoreBoard.
 */
public class MenuMoreBoard extends AbstractPage {

    /**
     * Find span.
     */
    @FindBy(css = ".board-menu-navigation-item-link.js-close-board")
    private WebElement linkCloseBoard;

    /**
     * Method for select link Close board in the object page MenuMoreBoard.
     *
     * @return page object CloseBoard.
     */
    public CloseBoardWraper selectLinkCloseBoard() {
        action.click(linkCloseBoard);
        WebElement btnConfirmClose;
        btnConfirmClose = driver.findElement(By.cssSelector("input.js-confirm.full.negate"));
        action.click(btnConfirmClose);
        return new CloseBoardWraper();
    }
}
