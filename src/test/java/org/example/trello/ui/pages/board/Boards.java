package org.example.trello.ui.pages.board;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.common.ISteps;
import org.example.trello.ui.pages.team.TeamCreation;

/**
 * Page object of the Boards page from Trello.
 */
public class Boards extends AbstractPage {

    @FindBy(css = "button[data-test-id='header-boards-menu-create-board']")
    private WebElement linkCreateNewTablero;

    @FindBy(css = "button[data-test-id='header-boards-menu-button'] > span")
    private WebElement btnTableros;

    @FindBy(css = "button[data-test-id='header-create-team-button']")
    private WebElement linkCreateNewTeam;

    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement linkCreateNewBoard;

    @FindBy(css = "button[data-test-id='header-create-menu-button']")
    private WebElement btnPlus;

    @FindBy(css = "input#org-display-name.js-autofocus.js-display-name")
    private WebElement nameTeamInputField;

    @FindBy(css = "[class='primary wide js-save']")
    private WebElement createTeamButton;

    @FindBy(xpath = "//*[@class='icon-lg icon-member']/ancestor::div[contains(@class,'mod-no-sidebar')]"
            + "/descendant::*[@class='board-tile mod-add']")
    private WebElement createBoardButton;

    private static final String WAY_BOARDS_PAGE = "boards page";
    private static final String WAY_QUICK_ADD = "quick add";
    private static final String WAY_BOARD_DRAWER = "board drawer";

    /**
     * Method for add a board using map.
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
        action.waitVisibility(btnTableros);
        action.click(btnTableros);
        action.waitVisibility(linkCreateNewTablero);
        action.click(linkCreateNewTablero);
    }

    /**
     * Way to create a Board by Quick Add from Header.
     */
    private void createBoardByQuickAdd() {
        By homeLeftSideBar = By.cssSelector(".home-left-sidebar-container");
        action.waitVisibility(homeLeftSideBar);
        action.waitVisibility(btnPlus);
        action.click(btnPlus);
        action.waitVisibility(linkCreateNewBoard);
        action.click(linkCreateNewBoard);
    }

    /**
     * Way to create a Board by Board Button on the main page.
     */
    private void createBoardByBoardButton() {
        action.waitVisibility(createBoardButton);
        action.click(createBoardButton);
    }

    /**
     * Method for create a team.
     *
     * @return the TeamCreation.
     */
    public TeamCreation clickCreateTeam() {
        action.pause();
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
