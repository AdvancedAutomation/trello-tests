@bvt
Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | New Board |

  Scenario: I delete a board as owner user
    Given I select board "New Board"
    And I close Board
    And I delete Board
    Then I don't should see the board "New Board"
    