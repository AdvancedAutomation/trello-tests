package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * this class represent a selected dashboard page.
 */
public class SelectedDashBoard extends AbstractPage {

    /**
     * Find span.
     */
    @FindBy(xpath = "//*[contains(@class,'icon-sm icon-add')]")
    private WebElement addListSpan;
    /**
     * Find name.
     */
    @FindBy(xpath = "//*[contains(@class,'list-name-input')]")
    private WebElement listName;
    /**
     * Find button.
     */
    @FindBy(xpath = "//*[contains(@class,'primary mod-list-add-button js-save-edit')]")
    private WebElement addListButton;
    /**
     * Find name .
     */
    @FindBy(xpath = "//a[contains(@class,'board-header-btn board-header-btn-name js-rename-board')]")
    private WebElement name;

    /**
     * @param nameList value or input.
     */
    public void addList(final String nameList) {
//        action.click(addListSpan);
//        action.setValue(listName, nameList);
//        action.click(addListButton);
    }

    /**
     * @return name.
     */
    protected String getName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }
}
