package org.fundacionjala.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to create side bar add menu.
 */
public class SideBarAddMenu extends AbstractPage {
    @FindBy(className = "div[class='pop-over is-shown']")
    private WebElement addMenu;
    @FindBy(className = "a.js-new-board")
    private WebElement newBoard;
    @FindBy(className = "a.js-new-org")
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
