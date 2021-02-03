package org.example.trello.ui.pages.team;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.core.ui.AbstractPage;
import org.example.core.ui.Commons;
import org.example.trello.ui.pages.common.ISteps;

/**
 * Page object of the TeamCreation page from Trello.
 */
public class TeamCreation extends AbstractPage {

    private String uniqueNameTeam;

    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement nameTeamInputField;

    @FindBy(css = "textarea[name='desc']")
    private WebElement descriptionTeamInputField;

    @FindBy(css = "a.tabbed-pane-nav-item-button.js-org-members")
    private WebElement tabMenbers;

    @FindBy(css = "input.autocomplete-input")
    private WebElement userNameTextField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement buttonInvited;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement createTeamButton;

    /**
     * Method for add a members.
     */
    public void addMembers() {
        action.click(tabMenbers);
    }

    /**
     * Method for add a members.
     *
     * @param data is type map.
     * @return the instance of SelectedTeam
     */
    public SelectedTeam createTeam(final Map<TeamFields, String> data) {
        EnumMap<TeamFields, ISteps> teamSteps = new EnumMap<>(TeamFields.class);
        uniqueNameTeam = Commons.getUserFromKey(data.get(TeamFields.NAME));
        action.waitVisibility(nameTeamInputField);
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
     *
     * @return the name of team
     */
    public String getUniqueNameTeam() {
        return uniqueNameTeam;
    }
}
