package org.fundacionjala.trello.pages.board;

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

    @FindBy(css = ".js-open-settings")
    private WebElement linkSettingsBoard;

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

    /**
     * Method for select link Settings in the object page MenuMoreBoard.
     *
     */
    public void clickInLinkSettings() {
        action.click(linkSettingsBoard);
    }

    /**
     * Method for get the commenting permission of the board.
     * @param permmision String type.
     * @return string type of actual permission.
     */
    public String getPermmisionActual(final String permmision) {
        By actualpermmision = By.xpath(String.format("//*[@class='js-change-comments']//*[text()='%s']", permmision));
        return action.getValue(actualpermmision);
    }
}
