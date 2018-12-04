package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * Page object of the Creation page for dashboards.
 */
public class BoardCreation extends AbstractPage {
    private static final String KEY_PRIVACY = "Privacy";
    @FindBy(className = "subtle-input")
    private WebElement titleTextInputField;

    @FindBy(css = ".create-board-form button.primary")
    private WebElement createDashBoardButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']")
    private WebElement selectPrivacyButton;

    /**
     * Method for create a dashboard with some specs.
     *
     * @param data List of the data specs.
     * @return the PO of the Selected DashBoard.
     */
    public SelectedDashBoard createNewBoard(final Map<String, String> data) {
        Map<String, ISteps> dashboardSteps = new HashMap<>();
        dashboardSteps.put("Title", () -> action.setValue(titleTextInputField, data.get("Title")));
        dashboardSteps.put(KEY_PRIVACY, () -> selectPrivacy(data));
        dashboardSteps.put("Background", () -> selectBackground(data));
        for (String key : data.keySet()) {
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
    private void selectBackground(final Map<String, String> data) {
        final String locatorColorBackgraundButton = String.format("[class='background-grid-trigger'] [title=' %s ']",
                data.get("Background"));
        WebElement selectColorBgButton = driver.findElement(By.cssSelector(locatorColorBackgraundButton));
        action.click(selectColorBgButton);
    }

    /**
     * Method for select Privacy .
     *
     * @param data input map.
     */
    private void selectPrivacy(final Map<String, String> data) {
        action.click(selectPrivacyButton);
        final String locatorPrivacyButton = String.format("[class$='icon-%s']", data.get(KEY_PRIVACY));
        WebElement selectPrivacyList = driver.findElement(By.cssSelector(locatorPrivacyButton));
        action.click(selectPrivacyList);
        if (data.get(KEY_PRIVACY).contains("public")) {
            WebElement confirmPublicButton = driver.findElement(By.cssSelector("[class='js-confirm full primary']"));
            action.click(confirmPublicButton);
        }
    }
}
