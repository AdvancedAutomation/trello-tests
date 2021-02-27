package org.example.trello.ui.pages.board;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.ui.AbstractPage;
import org.example.trello.ui.pages.card.SelectedCard;
import org.example.trello.ui.pages.list.ListAction;

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
    @FindBy(css = ".board-header .js-board-editing-target")
    private WebElement name;

    @FindBy(css = ".list-header-extras-menu.js-open-list-menu")
    private WebElement menuList;

    @FindBy(css = "a.js-add-card")
    private WebElement addCardList;

    @FindBy(css = "textarea.list-card-composer-textarea.js-card-title")
    private WebElement inputTitleCardTextfield;

    @FindBy(css = ".js-add-card")
    private WebElement addCardButton;

    @FindBy(xpath = "//a[contains(@class,'card-detail-title-assist js-title-helper')]")
    private WebElement nameCard;

    @FindBy(xpath = "#permission-level .board-header-btn-text")
    private WebElement privacyName;

    @FindBy(css = ".js-show-sidebar")
    private WebElement linkShowMenu;

    @FindBy(css = ".js-open-manage-board-members")
    private WebElement inviteMemberButton;

    @FindBy(css = "button[data-test-id='team-invite-submit-button']")
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

    @FindBy(css = ".window-overlay .window")
    private WebElement windowOverlay;

    private By memberAccountTextField = By.cssSelector(".quiet.u-bottom");

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
        action.waitVisibility(name);
        return name.getText();
    }

    /**
     * @return privacy name.
     */
    public String getPrivacy() {
        return privacyName.getText().toLowerCase();
    }

    /**
     * @return color background of page.
     */
    public String getBG() {
        if (bg != null) {
            wait.until(ExpectedConditions.invisibilityOf(windowOverlay));
            By body = By.id("classic-body");
            action.waitVisibility(body);
            return driver.findElement(body).getCssValue("background-color");
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
        By buttonOpenCard = By.xpath(cardXpath);
        action.waitVisibility(buttonOpenCard);
        action.click(buttonOpenCard);
        return new SelectedCard();
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
        driver.navigate().refresh();
        By element = By.cssSelector("[class='board-menu js-fill-board-menu hide']");
        if (action.isExistingSelector(element)) {
            action.waitVisibility(linkShowMenu);
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
        action.waitVisibility(inviteMemberButton);
        action.jsClick(inviteMemberButton);
        action.waitVisibility(searchMemberInputText);
        action.setValue(searchMemberInputText, memberName);
        action.waitVisibility(memberItem);
        action.click(memberItem);
        action.waitVisibility(sendInvitationButton);
        action.click(sendInvitationButton);
    }

    /**
     * Method for get a username to member.
     *
     * @param accountKey Input name of the member.
     * @return type String.
     */
    public String membersManageToBoard(final String accountKey) {
        action.click(boardMembers);
        By member = By.xpath(String.format("//*[contains(@class,'board-header-popover')] //*[contains(@title,'%s')]",
                accountKey));
        action.waitVisibility(member);
        action.click(member);
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
        return action.isExistingSelector(element);
    }

    /**
     * this method open menu lsit.
     *
     * @param nameList input parameter.
     * @return object listAction type.
     */
    public ListAction openMenuList(final String nameList) {
        final String ancestor = "ancestor::div[contains(@class,'list js-list-content')]";
        final String descendant = "descendant::*[@class='list-header-extras']";
        By nameListSelected = By.xpath(String.format("//textarea[@aria-label='%s']/%s/%s",
                nameList, ancestor, descendant));
        action.waitVisibility(nameListSelected);
        action.click(nameListSelected);
        return new ListAction();
    }


    /**
     * Method for verify if the list exist in the board.
     *
     * @param nameList input  parameter.
     * @return type boolean if exist list.
     */
    public boolean verifyListExist(final String nameList) {
        By element = By.xpath(String.format("//textarea[@aria-label='%s']", nameList));
        return action.isExistingSelector(element);
    }

}
