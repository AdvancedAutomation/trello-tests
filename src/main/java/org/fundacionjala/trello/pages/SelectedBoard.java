package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * this class represent a selected board page.
 */
public class SelectedBoard extends AbstractPage {

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

    @FindBy(xpath = "//textarea[@aria-label=\"To do\"]/ancestor::div[contains(@class, 'js-list-content')]/descendant::"
                    + "span[contains(text(), 'card1')]")
    private WebElement buttonOpenCard;

    @FindBy(xpath = "//a[contains(@class,'card-detail-title-assist js-title-helper')]")
    private WebElement nameCard;

    @FindBy(xpath = "//a[contains(@class,'board-header-btn perms-btn js-change-vis')]")
    private WebElement privacyName;

    @FindBy(css = ".window-overlay .window")
    private WebElement windowOverlay;

    private String privacy, bg;

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
    public String getName() {
        wait.until(ExpectedConditions.visibilityOf(name));
        return name.getText();
    }

    /**
     *
     * @return privacy name.
     */
    public String getPrivacy() {
        if (privacy != null) {
            wait.until(ExpectedConditions.visibilityOf(privacyName));
            return privacyName.getText().toLowerCase();
        }
        return null;
    }

    /**
     *
     * @return color background of page.
     */
    public String getBG() {
        if (bg != null) {
            wait.until(ExpectedConditions.invisibilityOf(windowOverlay));
            return driver.findElement(By.id("classic-body")).getCssValue("background-color");
        }
        return null;
    }

    /**
     * Method for create a Card.
     * @param data is name of card.
     */
    public void clickAddCard(final String data) {
        action.click(menuList);
        action.click(addCardList);
        action.setValue(inputTitleCardTextfield, data);
        action.click(addCardButton);
    }

    /**
     * Method for to do click in the card new.
     * @return SelectedCard.
     */
    public SelectedCard clickOpenCard() {
        action.click(buttonOpenCard);
        return new SelectedCard();
    }

    /**
     * It stores the privacy selected.
     * @param privacy is the privacy selected.
     */
    public void setPrivacy(final String privacy) {
        this.privacy = privacy;
    }

    /**
     * It stores the color background selected.
     * @param bg is the background color selected.
     */
    public void setBg(final String bg) {
        this.bg = bg;
    }
}
