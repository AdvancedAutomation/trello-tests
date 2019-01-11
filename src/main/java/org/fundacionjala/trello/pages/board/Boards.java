package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.team.TeamCreation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Boards page from Trello.
 */
public class Boards extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'quiet-button js-add-board')]")
    private WebElement linkCreateNewTablero;


    @FindBy(css = "span.header-btn-text")
    private WebElement btnTableros;

    @FindBy(css = "a.js-new-org")
    private WebElement linkCreateNewTeam;

    @FindBy(css = "a.js-new-board")
    private WebElement linkCreateNewBoard;

    @FindBy(css = "a.header-btn.js-open-add-menu")
    private WebElement btnPlus;

    @FindBy(css = "input#org-display-name.js-autofocus.js-display-name")
    private WebElement nameTeamInputField;

    @FindBy(css = "[class='primary wide js-save']")
    private WebElement createTeamButton;

    @FindBy(css = ".boards-page-board-section-list .board-tile.mod-add")
    private WebElement createBoardButton;

    /**
     * Method for add a board.
     *
     * @param place place where board will be created from.
     * @return the PO of Board Creation.
     */
    public BoardCreation clickAddBoard(final String place) {
        if (place.equals("icon add")) {
            action.waitVisibility(btnPlus);
            action.click(btnPlus);
            action.waitVisibility(linkCreateNewBoard);
            action.click(linkCreateNewBoard);
        } else if (place.equals("boards page")) {
            action.waitVisibility(createBoardButton);
            action.click(createBoardButton);
        } else {
            action.waitVisibility(btnTableros);
            action.click(btnTableros);
            action.waitVisibility(linkCreateNewTablero);
            action.click(linkCreateNewTablero);
        }
        return new BoardCreation();
    }

    /**
     * Method for create a team.
     *
     * @return the TeamCreation.
     */
    public TeamCreation clickCreateTeam() {
        action.waitVisibility(btnPlus);
        action.click(btnPlus);
        action.waitVisibility(linkCreateNewTeam);
        action.click(linkCreateNewTeam);
        return new TeamCreation();
    }

    /**
     * Method to click Button Header Board.
     *
     * @return PO BoardsDrawer.
     */
    public BoardsDrawer clickBtnHeaderBoard() {
        action.waitVisibility(btnTableros);
        action.click(btnTableros);
        return new BoardsDrawer();
    }
}
