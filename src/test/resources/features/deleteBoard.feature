Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
  Scenario: I delete a board as owner user
    Given I delete the board with a:
    Then I should see the card "card1"