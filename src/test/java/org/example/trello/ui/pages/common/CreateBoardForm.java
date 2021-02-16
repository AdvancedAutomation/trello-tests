package org.example.trello.ui.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;

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
