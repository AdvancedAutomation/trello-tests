@wip
Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | Board Targaryen |

  Scenario: I delete a board as owner user
    When I close Board
    And I delete Board
    Then I shouldn't see the board "Board Targaryen"
