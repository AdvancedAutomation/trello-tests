package org.fundacionjala.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {
    @FindBy(id = "header")
    private WebElement headerDiv;
    @FindBy(className = "header-btn js-open-add-menu")
    private WebElement openAddMenu;
    @FindBy(className = "member-initials")
    private  WebElement memberInitials;

    public SideBarAddMenu onClickOpenAddMenu() {
        action.click(openAddMenu);
        return new SideBarAddMenu();
    }

    public SideBarBoardsDrawer onClickOpenBoardsDrawer() {
        action.click(memberInitials);
        return new SideBarBoardsDrawer();
    }
}
