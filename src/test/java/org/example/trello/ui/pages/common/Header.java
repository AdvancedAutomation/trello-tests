package org.example.trello.ui.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

/**
 * Class Header top navigation.
 */
public class Header extends AbstractPage {
    @FindBy(id = "header")
    private WebElement headerDiv;
    @FindBy(css = ".header-btn.js-open-add-menu")
    private WebElement openAddMenu;
    @FindBy(css = ".member-initials")
    private  WebElement memberInitials;

    /**
     * Method on click open add menu web element.
     *
     * @return new Side bar add menu.
     */
    public SideBarAddMenu onClickOpenAddMenu() {
        action.click(openAddMenu);
        return new SideBarAddMenu();
    }

    /**
     * Method on click open boards drawer.
     *
     * @return new Side bar boards drawer.
     */
    public SideBarBoardsDrawer onClickOpenBoardsDrawer() {
        action.click(memberInitials);
        return new SideBarBoardsDrawer();
    }
}
