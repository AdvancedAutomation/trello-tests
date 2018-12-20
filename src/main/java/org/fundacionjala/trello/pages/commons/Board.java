package org.fundacionjala.trello.pages.commons;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class board.
 */
public class Board extends AbstractPage {
    @FindBy(css = ".list-name-input")
    private WebElement listName;

    @FindBy(css = ".mod-list-add-button")
    private WebElement buttonAddList;

    @FindBy(css = ".js-add-a-card")
    private WebElement buttonAddCard;

    @FindBy(xpath = "//*[@class=\"list-header js-list-header u-clearfix is-menu-shown is-subscribe-shown\"]")
    private WebElement headerList;

    @FindBy(xpath = "//*[@id=\"board\"]")
    private WebElement lists;

    /**
     * Method to add a new list into board.
     *
     * @param name type String
     */
    public void addList(final String name) {
        action.setValue(listName, name);
        action.click(buttonAddList);
    }

    /**
     * Method to return title list.
     *
     * @return tittle list.
     */
    public String getTitleList() {
        wait.until(ExpectedConditions.visibilityOf(headerList));
        return headerList.findElement(By.cssSelector("textarea.list-header-name.mod-list-name.js-list-name-input")).getText();
    }

    /**
     * Method to return size lists insert into board.
     *
     * @return number of elements list.
     */
    public int getSizeList() {
        return lists.findElements(By.cssSelector("div.js-list.list-wrapper")).size();
    }
}
