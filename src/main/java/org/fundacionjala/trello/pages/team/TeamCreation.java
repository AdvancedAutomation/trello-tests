package org.fundacionjala.trello.pages.team;

import org.fundacionjala.core.ui.AbstractPage;
import org.fundacionjala.core.ui.Commons;
import org.fundacionjala.trello.pages.common.ISteps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.EnumMap;
import java.util.Map;

/**
 * Page object of the TeamCreation page from Trello.
 */
public class TeamCreation extends AbstractPage {

    private String uniqueNameTeam;

    @FindBy(css = "input#org-display-name.js-autofocus.js-display-name")
    private WebElement nameTeamInputField;

    @FindBy(css = "textarea#org-desc")
    private WebElement descriptionTeamInputField;

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-members")
    private WebElement tabMenbers;

    @FindBy(css = "input.autocomplete-input")
    private WebElement userNameTextField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement buttonInvited;

    @FindBy(css = "[class='primary wide js-save']")
    private WebElement createTeamButton;

    /**
     * Method for add a members.
     */
    public void addMembers() {
        action.click(tabMenbers);
    }

    /**
     * Method for add a members.
     * @param data is type map.
     * @return the instance of SelectedTeam
     */
    public SelectedTeam createTeam(final Map<TeamFields, String> data) {
        EnumMap<TeamFields, ISteps> teamSteps = new EnumMap<>(TeamFields.class);
        uniqueNameTeam = Commons.getUserFromKey(data.get(TeamFields.NAME));
        teamSteps.put(TeamFields.NAME, () -> action.setValue(nameTeamInputField,
                uniqueNameTeam));
        teamSteps.put(TeamFields.DESCRIPTION, () -> action.setValue(descriptionTeamInputField,
                data.get(TeamFields.DESCRIPTION)));
        for (TeamFields key : data.keySet()) {
            teamSteps.get(key).run();
        }
        action.click(createTeamButton);
        return new SelectedTeam();
    }

    /**
     * Method for save unique name.
     * @return the name of team
     */
    public String getUniqueNameTeam() {
        return uniqueNameTeam;
    }
}
