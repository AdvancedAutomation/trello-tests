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

/**
 * Class for Clean all the information generate by an account.
 */
public class CleanData {
    private static final Logger LOGGER = LogManager.getLogger(CleanData.class.getName());
    private Environment environment = Environment.getInstance();

    /**
     * This method cleans all the teams.
     *
     * @param userKey Key of the user.
     */
    public void cleanAllTeams(final String userKey) {
        LOGGER.log(Level.INFO, String.format("Proceeding to clean all Teams of %s account", userKey));
        Login login = new Login();
        String userNameKey = String.format("$['credentials']['%s']['username']", userKey);
        String passwordKey = String.format("$['credentials']['%s']['password']", userKey);
        login.loginAs(environment.getValue(userNameKey), environment.getValue(passwordKey));
        Navigator navigator = new Navigator();
        Object[] teamsList = navigator.getAllTeams().stream().map(WebElement::getText).toArray();
        for (Object team : teamsList) {
            SideBarMain sideBarMain = new SideBarMain();
            SelectedTeam selectedTeam = sideBarMain.searchTeam(team.toString());
            TabSettings tabSettings = selectedTeam.openTabSettings();
            tabSettings.deleteTeam();
            navigator.goToMainPage();
        }
    }
}
