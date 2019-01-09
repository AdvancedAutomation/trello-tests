Feature: Delete card of a list

  Background: Create card to board in Trello
    Given I Log in with user "{credentials.owner1}"
    When I create a board from "board drawer" with a:
      | Title | ATB |
    And I add new list into board
      | Name | List Test |
    And I create a card with a:
      | card1 |

  Scenario: Delete a card
    Given I select the card:
      | List Name | List Test |
      | Card Name | card1     |
    When I archive the card
    And I delete the card
    Then I expect the card doesn't appear

