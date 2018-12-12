package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Map;

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
    @FindBy(css = "input.primary.mod-list-add-button.js-save-edit")
    private WebElement addListButton;
    /**
     * Find name .
     */
    @FindBy(xpath = "//a[contains(@class,'board-header-btn board-header-btn-name js-rename-board')]")
    private WebElement name;

    @FindBy(css = "a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-lg.icon-overflow-menu-horizontal")
    private WebElement menuList;

    @FindBy(css = "a.js-add-card")
    private WebElement addCardList;

    @FindBy(css = "textarea.list-card-composer-textarea.js-card-title")
    private WebElement inputTitleCardTextfield;

    @FindBy(css = "input.primary.confirm.mod-compact.js-add-card")
    private WebElement addCardButton;

    @FindBy(css = "span.list-card-title.js-card-name")
    private WebElement buttonCard;

    @FindBy(xpath = "//a[contains(@class,'card-detail-title-assist js-title-helper')]")
    private WebElement nameCard;

    /**
     * @param nameList value or input.
     */
    public void addList(final String nameList) {
        action.setValue(listName, nameList);
        action.click(addListButton);
    }

    /**
     * @return name.
     */
    protected String getName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }

    public void clickAddCard(String data) {
        action.click(menuList);
        action.click(addCardList);
        action.setValue(inputTitleCardTextfield, data);
        action.click(addCardButton);
    }

    public void verify(String value) {
        action.click(buttonCard);
    }
}
