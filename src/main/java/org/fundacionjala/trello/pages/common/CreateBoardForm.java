package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class to create a new board.
 */
public class CreateBoardForm extends AbstractPage {
    @FindBy(css = ".create-board-form")
    private WebElement createBoardForm;
    @FindBy(css = ".subtle-input")
    private WebElement subtitleInput;
    @FindBy(css = ".subtle-chooser-trigger")
    private WebElement subititleChoose;
    @FindBy(css = "button[type='submit']")
    private WebElement buttonSubmit;
}
