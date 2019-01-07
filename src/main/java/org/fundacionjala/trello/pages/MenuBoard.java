package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent the page object Menu Board.
 */
public class MenuBoard extends AbstractPage {

    /**
     * Find span.
     */

    @FindBy(css = ".board-menu-navigation-item-link.js-open-more")
    private WebElement linkMore;

    /**
     * Method for select link More in the object page Menuboard.
     *
     * @return page object MenuMoreBoard.
     */
    public MenuMoreBoard clickInLinkMore() {
        action.click(linkMore);
        return new MenuMoreBoard();
    }
}
