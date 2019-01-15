package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        action.click(driver.findElement(teamXpath));
    }

    /**
     * This method search a team using the header.
     *
     * @param teamName Input team name.
     * @return Selected Team Page Object.
     */
    public SelectedTeam searchTeam(final String teamName) {
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
}
