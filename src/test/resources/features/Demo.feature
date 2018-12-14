Feature: Create a board in Trello

  Scenario: Create a board

    Given I am on the Home page Trello
    When I Log with user "{credentials.owner1}"
    And I create a board with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    Then I should see the board
