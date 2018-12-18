Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board with a:
      | Title      | Board test  |
  Scenario: I delete a board as owner user
    Given I select board "Board test"
    And I close Board.
    And I delete Board.
    Then I don't should see the board.