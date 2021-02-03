package org.example.trello.ui.pages.board;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.common.ISteps;

/**
 * Page object of the Creation page for boards.
 */
public class BoardCreation extends AbstractPage {

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement titleTextInputField;

    @FindBy(css = "div[role='dialog'] button[data-test-id='create-board-submit-button']")
    private WebElement createBoardButton;

    @FindBy(css = "span[name='private']")
    private WebElement selectPrivacyButton;

    @FindBy(css = "input[data-test-id='create-board-title-input'] + button > span")
    private WebElement selectTeamButton;

    @FindBy(css = ".window-overlay .window")
    private WebElement windowOverlay;

    private String titleString;
    private String privacyString;
    private String backgroundString;

    private static final Map<String, String> COLORSBACKGROUND;

    static {
        Map<String, String> colors = new HashMap<>();
        colors.put("green", "rgba(81, 152, 57, 1)");
        colors.put("red", "rgba(176, 70, 50, 1)");
        colors.put("blue", "rgba(0, 121, 191, 1)");
        colors.put("orange", "rgba(210, 144, 52, 1)");
        colors.put("null", null);
        COLORSBACKGROUND = Collections.unmodifiableMap(colors);
    }

    /**
     * Method for create a board with some specs.
     *
     * @param data List of the data specs.
     * @return the PO of the Selected Board.
     */
    public SelectedBoard createNewBoard(final Map<BoardFields, String> data) {
        action.pause();
        EnumMap<BoardFields, ISteps> boardSteps = new EnumMap<>(BoardFields.class);
        titleString = data.get(BoardFields.TITLE);
        action.waitVisibility(titleTextInputField);
        boardSteps.put(BoardFields.TITLE, () -> action.setValue(titleTextInputField, titleString));
        boardSteps.put(BoardFields.PRIVACY, () -> selectPrivacy(data));
        boardSteps.put(BoardFields.BACKGROUND, () -> selectBackground(data));
        for (BoardFields key : data.keySet()) {
            boardSteps.get(key).run();
        }
        action.click(createBoardButton);
        wait.until(ExpectedConditions.invisibilityOf(windowOverlay));
        return new SelectedBoard();
    }

    /**
     * Method for select a Background.
     *
     * @param data input map.
     */
    private void selectBackground(final Map<BoardFields, String> data) {
        backgroundString = data.get(BoardFields.BACKGROUND);
        final String locatorColorBackgroundButton = String.format("div[role='dialog'] li button[title='%s']",
                backgroundString);
        By colorBgButton = By.cssSelector(locatorColorBackgroundButton);
        action.waitVisibility(colorBgButton);
        action.click(colorBgButton);
    }

    /**
     * Method for select Privacy .
     *
     * @param data input map.
     */
    private void selectPrivacy(final Map<BoardFields, String> data) {
        privacyString = data.get(BoardFields.PRIVACY).toLowerCase();
        if (privacyString.equals("public")) {
            action.click(selectPrivacyButton);
            String privacyButtonString = String.format("[class$='icon-%s']", privacyString);
            By privacyButtonLocator = By.cssSelector(privacyButtonString);
            action.waitVisibility(privacyButtonLocator);
            action.click(privacyButtonLocator);
            By confirmPublicButtonLocator = By.cssSelector("[class='js-confirm full primary']");
            action.waitVisibility(confirmPublicButtonLocator);
            action.click(confirmPublicButtonLocator);
        }
    }

    /**
     * @return title of board created.
     */
    public String getTitleString() {
        return titleString;
    }

    /**
     * @return privacy of board created.
     */
    public String getPrivacyString() {
        return privacyString;
    }

    /**
     * @return background of board created.
     */
    public String getBackgroundString() {
        return COLORSBACKGROUND.get(backgroundString == null ? "null" : backgroundString.toLowerCase());
    }
}
