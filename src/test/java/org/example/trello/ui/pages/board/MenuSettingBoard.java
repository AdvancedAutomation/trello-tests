package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * This class represent the page object MenuMoreBoard.
 */
public class MenuSettingBoard extends AbstractPage {

    /**
     * Find span.
     */
    @FindBy(css = ".js-change-comments")
    private WebElement linkCommentingPermissions;

    /**
     * Method for select link permmision board in the object page MenuSettings Board.
     *
     * @param permmission Link permmision name.
     */
    public void changeCommentingPermmissionBoard(final String permmission) {
        action.click(linkCommentingPermissions);
        final By linkPermissionLocator = By.xpath(String.format("//*[@name='%s']", permmission));
        action.waitVisibility(linkPermissionLocator);
        action.click(linkPermissionLocator);
    }
}
