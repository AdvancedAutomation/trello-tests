package org.fundacionjala.trello.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.core.Environment;
import org.fundacionjala.core.ui.driver.DriverManager;
import org.fundacionjala.trello.pages.Navigator;
import org.fundacionjala.trello.pages.common.Login;
import org.fundacionjala.trello.pages.common.SideBarMain;
import org.fundacionjala.trello.pages.team.SelectedTeam;
import org.fundacionjala.trello.pages.team.TabSettings;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Class which runs all features.
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.fundacionjala.trello.cucumber"},
        plugin = {
                "pretty"
        },
        tags = {"@bvt"}
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    private Environment environment = Environment.getInstance();

    /**
     * this method execute before the tests.
     */
    @BeforeTest
    public void open() {
        Login login = new Login();
        String userNameKey = String.format("$['credentials']['%s']['username']", "owner1");
        String passwordKey = String.format("$['credentials']['%s']['password']", "owner1");
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

    /**
     * this method close the browser after the features finish.
     */
    @AfterTest
    public void close() {
        DriverManager.getInstance().getDriver().quit();
    }
}
