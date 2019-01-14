@bvt
Feature: Delete Team

  Background:
    Given I Log in with user "{credentials.owner1}"
    When I create a team with a:
      | Name        | {dateTime.Team01} |
#    And I go to the trello page

  Scenario: Delete a team
#    Given I select the Team "Team"
    When I go to team setting
    And I delete the team
    Then I shouldn't see the team in the left bar
