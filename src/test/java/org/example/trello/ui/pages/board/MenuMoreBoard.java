package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * This class represent the page object MenuMoreBoard.
 */
public class MenuMoreBoard extends AbstractPage {

    /**
     * Find span.
     */
    @FindBy(xpath = "//a[contains(@class,\"js-close-board\")]")
    private WebElement linkCloseBoard;

    @FindBy(css = ".js-open-settings")
    private WebElement linkSettingsBoard;

    @FindBy(css = ".js-confirm")
    private WebElement buttonConfirmClose;

    /**
     * Method for select link Close board in the object page MenuMoreBoard.
     *
     * @return page object CloseBoard.
     */
    public CloseBoardWraper selectLinkCloseBoard() {
        action.pause();
        action.waitVisibility(linkCloseBoard);
        action.click(linkCloseBoard);
        action.waitVisibility(buttonConfirmClose);
        action.click(buttonConfirmClose);
        return new CloseBoardWraper();
    }

    /**
     * Method for select link Settings in the object page MenuMoreBoard.
     */
    public void clickInLinkSettings() {
        action.click(linkSettingsBoard);
    }

    /**
     * Method for get the commenting permission of the board.
     *
     * @param permmission String type.
     * @return string type of actual permission.
     */
    public String getPermmissionActual(final String permmission) {
        By actualpermmision = By.xpath(String.format("//*[@class='js-change-comments']//*[text()='%s']", permmission));
        return action.getValue(actualpermmision);
    }
}
