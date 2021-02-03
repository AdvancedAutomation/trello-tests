package org.example.trello.ui.pages.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.example.core.ui.AbstractPage;

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

    @FindBy(css = ".list-header.js-list-header.is-menu-shown")
    private WebElement headerList;

    @FindBy(xpath = "//*[@id=\"board\"]")
    private WebElement lists;

    @FindBy(css = ".js-editing-target")
    private WebElement listEdit;

    @FindBy(css = ".list-header-name.mod-list-name.js-list-name-input")
    private WebElement listEditText;

    @FindBy(css = "a.list-header-extras-menu.dark-hover.js-open-list-menu.icon-lg.icon-overflow-menu-horizontal")
    private WebElement menuList;

    @FindBy(css = ".js-move-list")
    private WebElement moveList;

    @FindBy(css = ".header-search-input")
    private WebElement searchDrawer;

    @FindBy(css = ".search-results-section .compact-board-tile-link-text-name")
    private WebElement firstFoundFile;

    /**
     * Method to edit a list into board.
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
        By addAnotherList = By.cssSelector("[class=\"js-add-list list-wrapper mod-add is-idle\"]");
        if (action.isExistingSelector(addAnotherList)) {
            action.click(addAnotherList);
        }
        action.waitVisibility(listName);
        action.setValue(listName, name);
        action.waitVisibility(buttonAddList);
        action.click(buttonAddList);
    }

    /**
     * Method to add several list into existing board.
     *
     * @param lists type list of string.
     */
    public void addSeveralList(final List<String> lists) {
        for (String list : lists) {
            addList(list);
        }
    }

    /**
     * Method to return title list.
     *
     * @param listName Input name of an specific list.
     * @return tittle list.
     */
    public String getTitleList(final String listName) {
        action.waitVisibility(headerList);
        String listXpath = String.format("//*[text()=\"%s\" and contains(@class,\"js-list-name-input\")]", listName);
        By listSelectorName = By.xpath(listXpath);
        action.waitVisibility(listSelectorName);
        return headerList.findElement(listSelectorName).getText();
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
        action.waitVisibility(menuList);
        action.click(menuList);
        action.waitVisibility(moveList);
        action.click(moveList);
        By selectBoard = By.cssSelector("select.js-select-board");
        Select dropdown = new Select(driver.findElement(selectBoard));
        dropdown.selectByVisibleText(board);
        By moveButton = By.xpath("//*[@class='primary wide js-commit-position']");
        action.waitVisibility(moveButton);
        action.click(moveButton);
        action.pause();
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
