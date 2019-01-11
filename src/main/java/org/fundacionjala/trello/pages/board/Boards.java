package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.common.ISteps;
import org.fundacionjala.trello.pages.team.TeamCreation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

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

    private static final String WAY_BOARDS_PAGE = "boards page";
    private static final String WAY_QUICK_ADD = "quick add";
    private static final String WAY_BOARD_DRAWER = "board drawer";

    /**
     * Method for add a board.
     *
     * @param way way where board will be created from.
     * @return the PO of Board Creation.
     */
    public BoardCreation clickAddBoard(final String way) {
        HashMap<String, ISteps> waysToCreateBoard = new HashMap<>();
        waysToCreateBoard.put(WAY_BOARDS_PAGE, this::createBoardByBoardButton);
        waysToCreateBoard.put(WAY_QUICK_ADD, this::createBoardByQuickAdd);
        waysToCreateBoard.put(WAY_BOARD_DRAWER, this::createBoardByBoardDrawer);
        waysToCreateBoard.get(way).run();
        return new BoardCreation();
    }

    /**
     * Way to create a Board from Board Drawer.
     */
    private void createBoardByBoardDrawer() {
        action.click(btnTableros);
        action.click(linkCreateNewTablero);
    }

    /**
     * Way to create a Board by Quick Add from Header.
     */
    private void createBoardByQuickAdd() {
        action.click(btnPlus);
        action.click(linkCreateNewBoard);
    }

    /**
     * Way to create a Board by Board Button on the main page.
     */
    private void createBoardByBoardButton() {
        action.click(createBoardButton);
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
        action.click(btnTableros);
        return new BoardsDrawer();
    }
}
