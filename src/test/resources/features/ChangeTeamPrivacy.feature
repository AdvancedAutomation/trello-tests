@wip
Feature: change team privacy

  Background: Create a team in Trello
    Given I Log in with user "{credentials.owner1}"
    When I create a team with a:
      | teamName | AT-08 |


  Scenario: change  team privacy
    When I select tab settings:
    And I change the privacy of the team:
      | privacy | public |
    Then I see the privacy change in team