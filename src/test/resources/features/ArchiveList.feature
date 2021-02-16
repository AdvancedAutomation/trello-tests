@bvt
Feature: Archive list to an existing board.
  As a user owner I want to archive list to my board.

  Background:
    Given I Log in with user "{credentials.owner2}"
    And I create a board from "board drawer" with a:
      | Title      | Board Tully |
      | Privacy    | private     |
      | Background | green       |
    And I add new list into board
      | Name | new list |

  Scenario: I delete a list to board
    When I archive the list:
      | Name | new list |
    Then I shouldn't see the list:
      | Name | new list |
    And I close Board
    And I delete Board
