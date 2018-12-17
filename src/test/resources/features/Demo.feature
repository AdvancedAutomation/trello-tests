Feature: Create a Dashboard in Trello

  Scenario: Create dashboard

    Given I Log in with user "{credentials.owner1}"
    When I create a dashboard with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    Then I should see the board

