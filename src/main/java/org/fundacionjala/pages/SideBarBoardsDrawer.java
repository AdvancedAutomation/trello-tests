package org.fundacionjala.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to create a new side bar boards drawer.
 */
public class SideBarBoardsDrawer {
    @FindBy(className = "boards-drawer is-shown")
    private WebElement boardsDrawer;
}
