package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
