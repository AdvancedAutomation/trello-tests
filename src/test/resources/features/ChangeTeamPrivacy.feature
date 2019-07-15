@wip
Feature: change team privacy

  Background: Create a team in Trello
    Given I Log in with user "{credentials.owner1}"
    And I create a team with a:
      | Name        | {dateTime.Team01} |
      | Description | any               |

  Scenario: change  team privacy
    When I go to tab setting
    And I change the privacy of the team:
      | privacy | public |
    Then I see the privacy change in team:
      | privacy | public |
