Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | New Board |
    And I select board "New Board"

  Scenario: I delete a board as owner user
    And I close Board
    Then The "New Board" board should be close
    