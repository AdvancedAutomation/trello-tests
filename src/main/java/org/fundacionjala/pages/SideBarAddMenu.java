package org.fundacionjala.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to create side bar add menu.
 */
public class SideBarAddMenu {
    @FindBy(className = "pop-over is-shown")
    private WebElement addMenu;
}
