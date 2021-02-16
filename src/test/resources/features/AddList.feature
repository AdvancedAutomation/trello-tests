@bvt
Feature: Add new list to an existing board.
  As a user owner I want to add a new list to my board.

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title      | Board Stark |
      | Privacy    | private     |
      | Background | green       |

  Scenario: As a user owner logged into trello's home page
    When I add new list into board
      | Name | To Do |
    Then I should see the list
    And I close Board
    And I delete Board
