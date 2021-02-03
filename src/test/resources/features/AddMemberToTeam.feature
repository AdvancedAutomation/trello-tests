@wip
Feature: Add member to Team in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a team with a:
      | Name | {dateTime.Team01} |

  Scenario: Add a member to Team
    When I select tab members
    And I invite a member to the Team:
      | "{credentials.member1}" |
    Then I should see to the member "{credentials.member1}" in the tab members
