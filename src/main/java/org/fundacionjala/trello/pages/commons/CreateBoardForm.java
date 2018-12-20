package org.fundacionjala.trello.pages.commons;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to create a new board.
 */
public class CreateBoardForm extends AbstractPage {
    @FindBy(className = "create-board-form")
    private WebElement createBoardForm;
    @FindBy(className = "subtle-input")
    private WebElement subtitleInput;
    @FindBy(className = "subtle-chooser-trigger")
    private WebElement subititleChoose;
    @FindBy(className = "button[type='submit']")
    private WebElement buttonSubmit;
}
