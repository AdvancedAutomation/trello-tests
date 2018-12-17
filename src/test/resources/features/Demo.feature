Feature: Create a Dashboard in Trello

  Scenario: Create dashboard

    Given I am on the Home page Trello
    When I Log in with user "{credentials.owner1}"
    And I create a dashboard with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    Then I should see the board

