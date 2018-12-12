package org.fundacionjala.trello.pages;

import org.fundacionjala.core.ui.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page object of the Boards page from Trello.
 */
public class Boards extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'quiet-button js-add-board')]")
    private WebElement linkCreateNewTablero;


    @FindBy(className = "header-btn-text")
    private WebElement btnTableros;



    @FindBy(css = "a.js-new-org")
    private WebElement linkCreateNewTeam;

    @FindBy(css = "a.header-btn.js-open-add-menu")
    private WebElement btnPlus;

    @FindBy(css = "input#org-display-name.js-autofocus.js-display-name")
    private WebElement nameTeamInputField;

    @FindBy(css = "[class='primary wide js-save']")
    private WebElement createTeamButton;

    /**
     * Method for add a dashboard.
     *
     * @return the PO of Board Creation.
     */
    public BoardCreation clickAddBoard() {
        action.click(btnTableros);
        action.click(linkCreateNewTablero);
        return new BoardCreation();
    }

    /**
     * Method for add a team.
     *
     * @return the PO of Board Creation.
     */
    public TeamCreation clickCreateTeam(String nameTeam) {
        action.click(btnPlus);
        action.click(linkCreateNewTeam);
        action.setValue(nameTeamInputField, nameTeam);
        action.click(createTeamButton);
        return new TeamCreation();
    }
}
