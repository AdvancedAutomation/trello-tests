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
     * @param permmission Link permmision name.
     */
    public void changeCommentingPermmissionBoard(final String permmission) {
        action.click(linkCommentingPermissions);
        WebElement linkPermmisions;
        linkPermmisions = driver.findElement(By.xpath(String.format("//*[@name='%s']", permmission)));
        action.click(linkPermmisions);
    }
}
