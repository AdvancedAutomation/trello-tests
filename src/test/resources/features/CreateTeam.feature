Feature: Create a Team in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"

  Scenario: Create Team
    When I create a team with a:
      | Name        | {dateTime.Team01} |
      | Description | any                     |
    And I store as "Team01"
    Then I should see the team new "{Team01.Name}"

