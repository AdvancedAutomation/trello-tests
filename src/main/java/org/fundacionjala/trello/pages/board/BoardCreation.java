package org.fundacionjala.trello.pages.board;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.common.ISteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page object of the Creation page for boards.
 */
public class BoardCreation extends AbstractPage {

    @FindBy(className = "subtle-input")
    private WebElement titleTextInputField;

    @FindBy(css = ".create-board-form button.primary")
    private WebElement createBoardButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']")
    private WebElement selectPrivacyButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']")
    private WebElement selectTeamButton;

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
        EnumMap<BoardFields, ISteps> boardSteps = new EnumMap<>(BoardFields.class);
        titleString = data.get(BoardFields.TITLE);
        boardSteps.put(BoardFields.TITLE, () -> action.setValue(titleTextInputField, titleString));
        boardSteps.put(BoardFields.PRIVACY, () -> selectPrivacy(data));
        boardSteps.put(BoardFields.BACKGROUND, () -> selectBackground(data));
        for (BoardFields key : data.keySet()) {
            boardSteps.get(key).run();
        }
        action.click(createBoardButton);
        action.waitVisibility(windowOverlay);
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
        final String locatorColorBackgroundButton = String.format("[class='background-grid-trigger'][title='%s']",
                backgroundString);
        WebElement selectColorBgButton = driver.findElement(By.cssSelector(locatorColorBackgroundButton));
        action.click(selectColorBgButton);
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
            final String locatorPrivacyButton = String.format("[class$='icon-%s']", privacyString);
            WebElement selectPrivacyList = driver.findElement(By.cssSelector(locatorPrivacyButton));
            action.click(selectPrivacyList);
            WebElement confirmPublicButton = driver.findElement(By.cssSelector("[class='js-confirm full primary']"));
            action.click(confirmPublicButton);
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
