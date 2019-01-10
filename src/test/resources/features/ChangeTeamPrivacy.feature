@bvt
Feature: change team privacy

  Background: Create a team in Trello
    Given I Log in with user "{credentials.owner1}"
    When I create a team with a:
      | teamName | AT-08 |
    And I go to Trello main page:

  Scenario: change  team privacy
    Given I select a team with:
      | teamName | AT-08 |
    When I select settings item list
    And I change the privacy of the team:
      | privacy | public |
    Then I see the privacy change in team