package org.fundacionjala.core;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.trello.pages.Navigator;
import org.fundacionjala.trello.pages.common.Login;
import org.fundacionjala.trello.pages.common.SideBarMain;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.fundacionjala.trello.pages.team.TabSettings;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for Clean all the information generate by an account.
 */
public final class CleanData {
    private static final Logger LOGGER = LogManager.getLogger(CleanData.class.getName());
    private static final Environment ENVIRONMENT = Environment.getInstance();

    /**
     * Empty constructor.
     */
    private CleanData() {
    }

    /**
     * This method cleans all the teams.
     *
     * @param userKey Key of the user.
     */
    public static void cleanAllTeams(final String userKey) {
        LOGGER.log(Level.INFO, String.format("Proceeding to clean all Teams of %s account", userKey));
        Login login = new Login();
        String userNameKey = String.format("$['credentials']['%s']['username']", userKey);
        String passwordKey = String.format("$['credentials']['%s']['password']", userKey);
        login.loginAs(ENVIRONMENT.getValue(userNameKey), ENVIRONMENT.getValue(passwordKey));
        Navigator navigator = new Navigator();
        List<String> teamsList = navigator.getAllTeams().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for (String team : teamsList) {
            SideBarMain sideBarMain = new SideBarMain();
            SelectedTeam selectedTeam = sideBarMain.searchTeam(team);
            TabSettings tabSettings = selectedTeam.openTabSettings();
            tabSettings.deleteTeam();
            navigator.goToMainPage();
        }
    }
}
