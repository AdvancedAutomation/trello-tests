package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.List;

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

    @FindBy(css = ".js-editing-target")
    private WebElement listEdit;

    @FindBy(css = ".list-header-name.mod-list-name.js-list-name-input")
    private WebElement listEditText;

    /**
     * Method to edit a list into board
     *
     * @param name type String
     */
    public void editList(final String name) {
        action.click(listEdit);
        listEditText.clear();
        action.setValue(listEditText, name);
        action.click(buttonAddList);
    }

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
     * Method to add several list into existing board.
     *
     * @param lists type list of string.
     */
    public void addSeveralList(final List<String> lists) {
        for (Iterator<String> it = lists.iterator(); it.hasNext();) {
            addList(it.next());
        }
    }

    /**
     * Method to return title list.
     *
     * @return tittle list.
     */
    public String getTitleList() {
        wait.until(ExpectedConditions.visibilityOf(headerList));
        String selector = "textarea.list-header-name.mod-list-name.js-list-name-input";
        return headerList.findElement(By.cssSelector(selector)).getText();
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
