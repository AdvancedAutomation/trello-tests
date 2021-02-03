@wip
Feature: Delete list to an existing board.
  As a user owner I want to delete list to my board.

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | Team Board 18 |
    And I add new list into board
      | Name | new list |

  Scenario: I delete a list to board
    And I delete the list
    Then I shouldn't see the list
