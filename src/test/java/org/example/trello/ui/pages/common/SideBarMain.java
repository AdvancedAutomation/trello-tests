package org.example.trello.ui.pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.board.SelectedBoard;
import org.example.trello.ui.pages.team.SelectedTeam;

/**
 * Class of the SideBard of Main page.
 */
public class SideBarMain extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'Settings')]")
    private WebElement teamSettingSideBar;

    @FindBy(xpath = "//*[contains(@data-test-id,'home-team-tab-section')]")
    private WebElement anyTeamSelected;

    @FindBy(css = ".header-search-input")
    private WebElement searchInputText;

    @FindBy(css = "a.link-item")
    private WebElement teamResult;

    @FindBy(xpath = "//*[@class=\"board-results-list js-list\"]/child::li[@class=\"compact-board-tile\"]")
    private WebElement boardResult;

    /**
     * Method for select team of the side bar.
     *
     * @param teamName Input String.
     */
    public void selectTeam(final String teamName) {
        action.pause();
        By teamXpath = By.xpath(
                String.format("//*[contains(text(),'%s')]/ancestor::a[contains(@class,'tab__tabLink__3C9rw')]",
                        teamName));
        action.waitVisibility(teamXpath);
        action.click(teamXpath);
    }

    /**
     * This method search a team using the header.
     *
     * @param teamName Input team name.
     * @return Selected Team Page Object.
     */
    public SelectedTeam searchTeam(final String teamName) {
        action.waitVisibility(searchInputText);
        action.setValue(searchInputText, teamName);
        action.waitVisibility(teamResult);
        action.click(teamResult);
        action.pause();
        return new SelectedTeam();
    }

    /**
     * Method to click to the team settings.
     */
    public void goTeamSettings() {
        action.pause();
        action.click(teamSettingSideBar);
    }

    /**
     * Method for search an specific board.
     *
     * @param boardName Input board name.
     * @return Selected Board PO.
     */
    public SelectedBoard searchBoard(final String boardName) {
        action.waitVisibility(searchInputText);
        action.setValue(searchInputText, boardName);
        action.waitVisibility(boardResult);
        action.click(boardResult);
        action.pause();
        return new SelectedBoard();
    }
}
