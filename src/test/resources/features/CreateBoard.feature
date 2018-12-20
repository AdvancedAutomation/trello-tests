Feature: Create a Board in Trello
  Background:
    Given I Log in with user "{credentials.owner1}"
  Scenario: Create Board
    When I create a board with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    Then I should see the board

  Scenario: Create new Board
    When I create a board with a:
      | Title      | baco    |
      | Privacy    | private |
      | Background | red     |
    Then I should see the board

