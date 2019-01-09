package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarMain extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'Settings')]")
    private WebElement teamSettingSideBar;

    public void selectTeam(final String teamName) {
        By teamXpath = By.xpath("//*[contains(text(),'" + teamName + "')]/ancestor::a[contains(@class,'tab__tabLink__3C9rw')]");
        action.click(driver.findElement(teamXpath));
    }

    public void goTeamSettings() {
        action.click(teamSettingSideBar);
    }
}
