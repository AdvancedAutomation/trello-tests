package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * This class represent the page object member Menu.
 */
public class MemberMenu extends AbstractPage {

    @FindBy(css = ".js-profile")
    private WebElement linkProfile;

    @FindBy(css = ".js-cards")
    private WebElement linkCards;

    @FindBy(css = ".js-account")
    private WebElement linkSettings;

    @FindBy(css = ".js-change-locale")
    private WebElement linkChangeLanguage;

    @FindBy(css = ".js-open-header-member-menu")
    private WebElement memberMenu;

    /**
     * Method for select the language for the account.
     *
     * @param language String type.
     */
    public void changeLocate(final String language) {
        action.waitVisibility(linkChangeLanguage);
        action.click(linkChangeLanguage);
        By labelColorButton = By.xpath(String
                .format("//*[@class='js-select-locale'] [contains(text(),'%s')]", language));
        action.waitVisibility(labelColorButton);
        action.click(labelColorButton);
        final int timeOut = 1000;
        action.pause(timeOut);
        By homeLeftSideBar = By.cssSelector(".home-left-sidebar-container");
        action.waitVisibility(homeLeftSideBar);
    }

    /**
     * Method to go to Member menu.
     *
     * @return instance of MemberMenu.
     */
    public MemberMenu goMemberMenu() {
        action.waitVisibility(memberMenu);
        action.click(memberMenu);
        return new MemberMenu();
    }

    /**
     * This method verifies the language of the selector profile.
     *
     * @param language Input element language.
     * @return The boolean.
     */
    public boolean verifyLanguage(final String language) {
        By profileSelector = By.xpath("");
        if (language.equals("Español")) {
            profileSelector = By.xpath("//*[@lang=\"es\"]");
        }
        if (language.equals("English (US)")) {
            profileSelector = By.xpath("//*[@lang=\"en-US\"]");
        }
        action.waitVisibility(profileSelector);
        return action.isExistingSelector(profileSelector);
    }
}
