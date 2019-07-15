@wip
Feature: Delete Team

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a team with a:
      | Name        | {dateTime.Team01} |

  Scenario: Delete a team
    When I go to team setting
    And I delete the team
    Then I shouldn't see the team in the left bar
