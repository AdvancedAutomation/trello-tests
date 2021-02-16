@bvt
Feature: Add several list to an existing board.
  As a user owner I want to add a new list to my board.

  Background:
    Given I Log in with user "{credentials.owner2}"
    And I create a board from "board drawer" with a:
      | Title      | Board Baratheon |
      | Privacy    | private         |
      | Background | green           |

  Scenario: As a user owner logged into trello's home page
    When I add several lists into board
      | To Do       |
      | In Progress |
      | Done        |
    Then I should see these 3 lists
    And I close Board
    And I delete Board
