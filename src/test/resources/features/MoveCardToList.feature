@wip
Feature: Change card position.

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "quick add" with a:
      | Title | Test Board |
    And I add new list into board
      | Name | list 1 |
    And I create a card with a:
      | card1 |
    And I add new list into board
      | Name | list 2 |

  Scenario: Change card to another list
    When I select the card:
      | List Name | list 1 |
      | Card Name | card1  |
    And move card to list:
      | Name | list 2 |
    Then I see to card in another list:
      | List Name | list 2 |
      | Card Name | card1  |
