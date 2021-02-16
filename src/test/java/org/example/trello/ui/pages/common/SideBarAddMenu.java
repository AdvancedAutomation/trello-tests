package org.example.trello.ui.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * Class to create side bar add menu.
 */
public class SideBarAddMenu extends AbstractPage {
    @FindBy(css = ".pop-over.is-shown")
    private WebElement addMenu;
    @FindBy(css = ".js-new-board")
    private WebElement newBoard;
    @FindBy(css = ".js-new-org")
    private WebElement newTeam;


    /**
     * Method to create a new board form.
     *
     * @return a new page object board form.
     */
    public CreateBoardForm onClickNewBoard() {
        action.click(newBoard);
        return new CreateBoardForm();
    }
}
