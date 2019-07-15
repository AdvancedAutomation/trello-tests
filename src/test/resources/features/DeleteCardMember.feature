@wip
Feature: Delete member to Card in Trello

  Background: Create list to board in Trello
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | ATB 09 |
    And I add new list into board
      | Name | To Do |
    And I create a card with a:
      | card1 |
    And I invite a member to the Board:
      | Member | "{credentials.member1}" |
    And I select the card:
      | List Name | To Do |
      | Card Name | card1 |
    And I assign a member to the card:
      | Member | "{credentials.member1}" |

  Scenario: Delete Member to card
    When I remove from card to user:
      | Member | "{credentials.member1}" |
    Then I should see the card without the user:
      | Member | "{credentials.member1}" |
