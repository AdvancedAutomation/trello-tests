@wip
Feature: Create a Card in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | Version |
    And I add new list into board
      | Name | To Do |

  Scenario: I create a card as owner user
    Given I create a card with a:
      | card1 |
    When I select the card:
      | List Name | To Do |
      | Card Name | card1 |
    Then I should see the card "card1"
