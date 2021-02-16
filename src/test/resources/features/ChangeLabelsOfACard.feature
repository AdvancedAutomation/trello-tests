@wip
Feature: Change labels of a card

  Background: Create board in Trello
    Given I Log in with user "{credentials.owner3}"
    And I create a board from "board drawer" with a:
      | Title | Board Tyrell |
    And I add new list into board
      | Name | To Do |
    And I create a card with a:
      | card1 |

  Scenario: Change labels of a card
    When I select the card:
      | List Name | To Do |
      | Card Name | card1 |
    And I change label to:
      | Color | green |
    Then I should see the card with label "green"
