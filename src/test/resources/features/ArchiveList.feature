@bvt
Feature: Archive list to an existing board.
  As a user owner I want to archive list to my board.

  Background:
    Given I Log in with user "{credentials.owner1}"
    When I create a board from "board drawer" with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    And I add new list into board
      | Name | new list |

  Scenario: I delete a list to board
    And I archive the list:
      | Name | new list |
    Then I don't should see the list:
      | Name | new list |
