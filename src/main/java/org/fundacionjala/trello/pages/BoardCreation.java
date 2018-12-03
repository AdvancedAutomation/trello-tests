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
        dashboardSteps.put("Privacy", () -> selectPrivacy(data));
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
        WebElement selectColorBgButton = driver.findElement(By.cssSelector("[class='background-grid-trigger']"
                + "[title='" + data.get("Background") + "']"));
        action.click(selectColorBgButton);
    }

    /**
     * Method for select privacy.
     *
     * @param data input map.
     */
    private void selectPrivacy(final Map<String, String> data) {
        action.click(selectPrivacyButton);

        WebElement selectPrivacyList = driver.findElement(By.cssSelector("[class$='icon-"
                + data.get("Privacy") + "']"));
        action.click(selectPrivacyList);

        if (data.get("Privacy").contains("public")) {
            WebElement confirmPublicButton = driver.findElement(By.cssSelector("[class='js-confirm full primary']"));
            action.click(confirmPublicButton);
        }
    }
}
