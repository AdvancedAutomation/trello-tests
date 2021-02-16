package org.example.trello.ui.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * Class to create a new side bar boards drawer.
 */
public class SideBarBoardsDrawer extends AbstractPage {
    @FindBy(css = ".boards-drawer.is-shown")
    private WebElement boardsDrawer;
    @FindBy(css = ".js-add-board")
    private WebElement addBoard;

    /**
     * Method to create a new board form.
     *
     * @return a new page object board form.
     */
    public CreateBoardForm onClickNewBoard() {
        addBoard.click();
        return new CreateBoardForm();
    }
}
