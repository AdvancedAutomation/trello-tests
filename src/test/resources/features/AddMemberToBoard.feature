Feature: Add member to Board in Trello

  Background: Create list to board in Trello
    Given I Log in with user "{credentials.owner1}"
    When I create a board from "board drawer" with a:
      | Title | ATB |

  Scenario: Add Member to board
    Given I invite a member to the Board:
      | Member | "{credentials.member1}" |
    Then I should see to the member "{credentials.member1}" in the board
