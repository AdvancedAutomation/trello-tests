@wip
Feature: Delete member to Board in Trello

  Background: Create list to board in Trello
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | ATB 30 |
    And I invite a member to the Board:
      | Member | "{credentials.member1}" |

  Scenario: Delete Member to board
    When I remove from boar to member
      | Member | "{credentials.member1}" |
    Then I not should see to the member "{credentials.member1}"
