@bvt
Feature: Add member a Team in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    When I create a team with a:
      | Name        | {dateTime.Team01} |
      | Description | any               |
    And I store as "Team01"

  Scenario: Add a member to Team
    Given I select tab members
    When I invite a member to the Team:
      | "{credentials.member1}" |
    Then I should see to the member "{credentials.member1}" in the tab members

