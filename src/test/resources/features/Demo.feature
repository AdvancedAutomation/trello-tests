Feature: Create a Dashboard in Trello

  Scenario: Create dashboard

    Given I am on the Home page Trello
    When I Log in with user 1
    And I create a dashboard with a:
#      | Privacy    | private        |
      | Title      | Hola my friend |
#      | Background | pink           |
    Then I should see the dashboard
