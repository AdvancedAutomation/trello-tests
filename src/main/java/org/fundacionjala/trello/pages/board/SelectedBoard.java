package org.fundacionjala.trello.pages.board;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.trello.pages.card.SelectedCard;
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


    @FindBy(xpath = "//a[contains(@class,'card-detail-title-assist js-title-helper')]")
    private WebElement nameCard;

    @FindBy(xpath = "//a[contains(@class,'board-header-btn perms-btn js-change-vis')]")
    private WebElement privacyName;

    @FindBy(css = ".js-show-sidebar")
    private WebElement linkShowMenu;

    @FindBy(css = ".js-open-manage-board-members")
    private WebElement inviteMemberButton;

    @FindBy(css = ".autocomplete-btn.primary")
    private WebElement sendInvitationButton;

    @FindBy(css = ".autocomplete-input")
    private WebElement searchMemberInputText;

    @FindBy(css = "[class=full-name]")
    private WebElement memberItem;

    @FindBy(css = ".js-fill-board-member-count")
    private WebElement boardMembers;

    @FindBy(css = ".js-remove-member")
    private WebElement removeMemberToBoard;

    @FindBy(css = ".js-confirm.full.negate")
    private WebElement removeMemberBotton;

    private By memberAccountTextField = By.cssSelector(".quiet.u-bottom");

    private String privacy;
    private String bg;

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
     * @return color background of page.
     */
    public String getBG() {
        if (bg != null) {
            action.waitVisibility(windowOverlay);
            wait.until(ExpectedConditions.invisibilityOf(windowOverlay));
            return driver.findElement(By.id("classic-body")).getCssValue("background-color");
        }
        return null;
    }

    /**
     * Method for create a Card.
     *
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
     *
     * @param listName Input list name.
     * @param cardName Input card name.
     * @return SelectedCard object.
     */
    public SelectedCard selectCard(final String listName, final String cardName) {
        String firstLevel = String.format("//textarea[@aria-label='%s']", listName);
        String secondLevel = "/ancestor::div[contains(@class, 'js-list-content')]";
        String thirdLevel = String.format("/descendant::span[contains(text(), '%s')]", cardName);
        String cardXpath = firstLevel.concat(secondLevel).concat(thirdLevel);
        WebElement buttonOpenCard = driver.findElement(By.xpath(cardXpath));

        action.click(buttonOpenCard);
        return new SelectedCard();
    }

    /**
     * It stores the privacy selected.
     *
     * @param privacy is the privacy selected.
     */
    public void setPrivacy(final String privacy) {
        this.privacy = privacy;
    }

    /**
     * It stores the color background selected.
     *
     * @param bg is the background color selected.
     */
    public void setBg(final String bg) {
        this.bg = bg;
    }

    /**
     * Method for click in the link Show menu.
     *
     * @return page object MenuBoard.
     */
    public MenuBoard clickShowMenu() {
        By element = By.cssSelector(".board-menu.js-fill-board-menu.hide");
        if (action.existSelectorBy(element)) {
            action.click(linkShowMenu);
        }
        return new MenuBoard();
    }

    /**
     * Method for invite a member to board.
     *
     * @param memberName Input name of the member.
     */
    public void inviteMember(final String memberName) {
        action.click(inviteMemberButton);
        action.setValue(searchMemberInputText, memberName);
        action.waitVisibility(memberItem);
        action.click(memberItem);
        action.click(sendInvitationButton);
    }

    /**
     * Method for get a username to member.
     *
     * @param accountKey Input name of the member.
     * @return type String.
     */
    public String membersManageToBoard(final String accountKey) {
        action.waitVisibility(boardMembers);
        action.click(boardMembers);
        By member = By.xpath(String.format("//*[contains(@class,'board-header-popover')] //*[contains(@title,'%s')]",
                accountKey));
        action.waitVisibility(driver.findElement(member));
        action.click(driver.findElement(member));
        return action.getValue(memberAccountTextField);
    }

    /**
     * Method for delete a member to board.
     */
    public void deleteMember() {
        action.click(removeMemberToBoard);
        action.click(removeMemberBotton);
    }

    /**
     * Method for verify if the member exist in the board.
     *
     * @param member username String type.
     * @return type boolean if exist the member.
     */
    public boolean verifyMemberExist(final String member) {
        By element = By.xpath(String.format("//*[contains(@title,'%s')]", member));
        return action.existSelectorBy(element);
    }
}
