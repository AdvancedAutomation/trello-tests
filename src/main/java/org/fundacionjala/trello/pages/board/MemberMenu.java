package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
     * @param language String type.
     */
    public void changeLocate(final String language) {
        action.click(linkChangeLanguage);
        By labelColorButton = By.xpath(String
                .format("//*[@class='js-select-locale'] [contains(text(),'%s')]", language));
        action.click(driver.findElement(labelColorButton));
    }

    /**
     * Method to go to Member menu.
     * @return instance of MemberMenu.
     */
    public MemberMenu goMemberMenu() {
        action.click(memberMenu);
        return new MemberMenu();
    }
}
