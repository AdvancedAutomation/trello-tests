@bvt
Feature: Edit list name

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title      | Team Three |
      | Privacy    | private    |
      | Background | green      |
    And I add new list into board
      | Name | To Do |

  Scenario: As a user owner logged into trello's home page edit list name
    When I select and edit the list
      | Name | new name |
    Then I should see the list
