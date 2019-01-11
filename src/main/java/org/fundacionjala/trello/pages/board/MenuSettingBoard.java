package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
     * @param permmision Link permmision name.
     */
    public void changeCommentingPermmisionBoard(final String permmision) {
        action.click(linkCommentingPermissions);
        WebElement linkPermmisions;
        linkPermmisions = driver.findElement(By.xpath(String.format("//*[@name='%s']", permmision)));
        action.click(linkPermmisions);
    }
}
