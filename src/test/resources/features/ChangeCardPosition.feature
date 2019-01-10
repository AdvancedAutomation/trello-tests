@bvt
Feature: Change card position.

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "new board" with a:
      | Title | Test Board |
    And I add new list into board
      | Title | list 1 |
    And I create a card with a:
      | Name | card 1 |
    And I add new list into board
      | Title | list 2 |

  Scenario: Change card to another list
    Given I select a card with:
      | Title | list 1 |
      | name  | card 1 |
    And I change to card:
      | List | list 2 |
    Then I expect card:
      | Title | list 2 |
      | name  | card 1 |