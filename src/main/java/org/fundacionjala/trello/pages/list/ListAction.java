package org.fundacionjala.trello.pages.list;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represented to list actions.
 */
public class ListAction extends AbstractPage {
    @FindBy(css = ".js-close-list")
    private WebElement arciveListButton;


    /**
     * Method to archive list.
     */
    public void archiveList() {
        action.waitVisibility(arciveListButton);
        action.click(arciveListButton);
    }
}
