package org.example.trello.ui.pages.list;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * this class represented to list actions.
 */
public class ListAction extends AbstractPage {
    @FindBy(css = ".js-close-list")
    private WebElement archiveListButton;


    /**
     * Method to archive list.
     */
    public void archiveList() {
        action.waitVisibility(archiveListButton);
        action.click(archiveListButton);
    }
}
