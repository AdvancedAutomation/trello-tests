package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class of the SideBard of Main page.
 */
public class SideBarMain extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'Settings')]")
    private WebElement teamSettingSideBar;

    /**
     * Method for select team of the side bar.
     *
     * @param teamName Input String.
     */
    public void selectTeam(final String teamName) {
        By teamXpath = By.xpath(
                String.format("//*[contains(text(),'%s')]/ancestor::a[contains(@class,'tab__tabLink__3C9rw')]",
                        teamName));
        action.click(driver.findElement(teamXpath));
    }

    /**
     * Method to click to the team settings.
     */
    public void goTeamSettings() {
        action.click(teamSettingSideBar);
    }
}
