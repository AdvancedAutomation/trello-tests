package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * this class represent a selected card page.
 */
public class SelectedTeam extends AbstractPage {

    @FindBy(css = ".tabbed-pane-header-details-name")
    private WebElement headerDetailsName;

    @FindBy(css = ".tabbed-pane-header-details-content")
    private WebElement headerDetailsContent;
}
