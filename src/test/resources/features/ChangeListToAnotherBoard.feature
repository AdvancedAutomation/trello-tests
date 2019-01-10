Feature: Change list to another board.

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | second Board9 |
    And I create a board from "board drawer" with a:
      | Title | first Board9 |
    And I add new list into board
      | Name | To Do |
  Scenario: As a user owner change list to other board
    Given I change the list to other board:
      | Board | second Board9 |
    When I open the board
      | Board | second Board9 |
    Then I should see the list in the board:
      | Board | second Board9 |
