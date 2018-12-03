package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BoardCreation extends AbstractPage {
    @FindBy(className = "subtle-input")
    WebElement titleTextInputField;

    @FindBy(css = ".create-board-form button.primary")
    WebElement createDashBoardButton;

    @FindBy(css = "[class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']")
    WebElement selectPrivacyButton;

    public SelectedDashBoard createNewBoard(List<String> data) {
        action.setValue(titleTextInputField, data.get(1));

        WebElement selectColorBgButton = driver.findElement(By.cssSelector("[class='background-grid-trigger']"
                + "[title='" + data.get(5) + "']"));
        action.click(selectColorBgButton);

        action.click(selectPrivacyButton);

        WebElement selectPrivacyList = driver.findElement(By.cssSelector("[class$='icon-" + data.get(3) + "']"));
        action.click(selectPrivacyList);

        if (data.get(3).contains("public")) {
            WebElement confirmPublicButton = driver.findElement(By.cssSelector("[class='js-confirm full primary']"));
            action.click(confirmPublicButton);
        }

        action.click(createDashBoardButton);
        return new SelectedDashBoard();
    }
}
