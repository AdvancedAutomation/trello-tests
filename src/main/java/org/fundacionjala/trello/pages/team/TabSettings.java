package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * PageObject of the Tab Settings inside of the Team page.
 */
public class TabSettings extends AbstractPage {

    @FindBy(css = "a[class='quiet-button']")
    private WebElement deleteButton;

    @FindBy(css = ".js-confirm")
    private WebElement confirmDeleteTeamButton;

    @FindBy(css = ".setting-item-action")
    private WebElement changePrivacyButton;

    @FindBy(css = ".home-left-sidebar-container")
    private WebElement leftSideBarContainer;

    /**
     * Method for delete the team.
     */
    public void deleteTeam() {
        if (action.existSelectorBy(By.cssSelector("a[class='quiet-button']"))) {
            action.waitVisibility(deleteButton);
            action.click(deleteButton);
            action.waitVisibility(confirmDeleteTeamButton);
            action.click(confirmDeleteTeamButton);
        }
//        action.waitVisibility(leftSideBarContainer);
    }

    /**
     * Method for change privacy Team.
     *
     * @param privacy input parameter.
     */
    public void changePrivacyTeam(final String privacy) {
        action.waitVisibility(changePrivacyButton);
        action.click(changePrivacyButton);
        By element = By.xpath(String.format("//ul[@class='pop-over-list']/descendant::*[@class='icon-sm icon-%s']",
                privacy));
        action.waitVisibility(driver.findElement(element));
        action.click(driver.findElement(element));
    }

    /**
     * Method for verify privacy change.
     *
     * @param privacy value of privacy .
     * @return true or false .
     */
    public boolean verifyChangePrivacyToTeam(final String privacy) {
        By element = By.xpath(String.format(
                "//div[@class='tabbed-pane-header-details-name']/descendant::*[@class='icon-sm icon-%s']", privacy));
        return action.existSelectorBy(element);
    }

}
