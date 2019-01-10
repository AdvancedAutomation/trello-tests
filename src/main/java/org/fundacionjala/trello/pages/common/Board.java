package org.fundacionjala.trello.pages.common;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(css = "a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-lg.icon-overflow-menu-horizontal")
    private WebElement menuList;

    @FindBy(css = ".js-move-list")
    private WebElement moveList;

    @FindBy(css = ".header-search-input")
    private WebElement searchDrawer;

    @FindBy(css = ".search-results-section .compact-board-tile-link-text-name")
    private WebElement firstFoundFile;


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

    /**
     * Method to change list to another board.
     *
     * @param board type String board destination.
     */
    public void changeListToBoard(final String board) {
        action.click(menuList);
        action.click(moveList);
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.js-select-board")));
        dropdown.selectByVisibleText(board);
        By moveButton = By.xpath("//*[@class='primary wide js-commit-position']");
        action.waitVisibility((WebElement) moveButton);
        action.click(driver.findElement(moveButton));
    }

    /**
     * Method to open a board.
     *
     * @param boardName type String.
     */
    public void openBoardDrawer(final String boardName) {
        action.setValue(searchDrawer, boardName);
        action.click(firstFoundFile);
    }
}
