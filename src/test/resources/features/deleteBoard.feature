Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
  Scenario: I delete a board as owner user
    Given I delete the board with a:
    Then Then I don't should see the board.