package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    public SelectedDashBoard createNewBoard(final List<String> data) {
        final int one = 1;
        final int three = 3;
        final int five = 5;
        action.setValue(titleTextInputField, data.get(one));

        WebElement selectColorBgButton = driver.findElement(By.cssSelector("[class='background-grid-trigger']"
                + "[title='" + data.get(five) + "']"));
        action.click(selectColorBgButton);

        action.click(selectPrivacyButton);

        WebElement selectPrivacyList = driver.findElement(By.cssSelector("[class$='icon-" + data.get(three) + "']"));
        action.click(selectPrivacyList);

        if (data.get(three).contains("public")) {
            WebElement confirmPublicButton = driver.findElement(By.cssSelector("[class='js-confirm full primary']"));
            action.click(confirmPublicButton);
        }

        action.click(createDashBoardButton);
        return new SelectedDashBoard();
    }
}
