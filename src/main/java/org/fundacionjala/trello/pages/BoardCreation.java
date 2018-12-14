package org.fundacionjala.trello.pages;

import java.util.EnumMap;
import java.util.Map;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Creation page for dashboards.
 */
public class BoardCreation extends AbstractPage {

    @FindBy(className = "subtle-input")
    private WebElement titleTextInputField;

    @FindBy(css = ".create-board-form button.primary")
    private WebElement createDashBoardButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']")
    private WebElement selectPrivacyButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button org-chooser-trigger']")
    private WebElement selectTeamButton;

    private String titleString;
    private String privacyString;
    private String backgroundString;


    /**
     * Method for create a dashboard with some specs.
     *
     * @param data List of the data specs.
     * @return the PO of the Selected DashBoard.
     */
    public SelectedDashBoard createNewBoard(final Map<BoardFields, String> data) {
        EnumMap<BoardFields, ISteps> dashboardSteps = new EnumMap<>(BoardFields.class);
        titleString = data.get(BoardFields.TITLE);
        dashboardSteps.put(BoardFields.TITLE, () -> action.setValue(titleTextInputField, titleString));
        dashboardSteps.put(BoardFields.PRIVACY, () -> selectPrivacy(data));
        dashboardSteps.put(BoardFields.BACKGROUND, () -> selectBackground(data));
        for (BoardFields key : data.keySet()) {
            dashboardSteps.get(key).run();
        }
        action.click(createDashBoardButton);
        return new SelectedDashBoard();
    }

    /**
     * Method for select a Background.
     *
     * @param data input map.
     */
    private void selectBackground(final Map<BoardFields, String> data) {
        backgroundString = data.get(BoardFields.BACKGROUND);
        final String locatorColorBackgraundButton = String.format("[class='background-grid-trigger'][title='%s']",
                backgroundString);
        WebElement selectColorBgButton = driver.findElement(By.cssSelector(locatorColorBackgraundButton));
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
     *
     * @return title of board created.
     */
    public String getTitleString() {
        return titleString;
    }

    /**
     *
     * @return privacy of board created.
     */
    public String getPrivacyString() {
        return privacyString;
    }

    /**
     *
     * @return background of board created.
     */
    public String getBackgroundString() {
        return backgroundString;
    }
}
