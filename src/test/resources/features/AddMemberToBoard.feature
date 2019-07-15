@wip
Feature: Add member to Board in Trello

  Background: Create list to board in Trello
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | ATB 18 |

  Scenario: Add Member to board
    When I invite a member to the Board:
      | Member | "{credentials.member1}" |
    Then I should see to the member "{credentials.member1}" in the board
