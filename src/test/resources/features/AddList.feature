Feature: Add new list to an existing board.
  As a user owner I want to add a new list to my board.

  Scenario: As a user owner loggin into trello's home page

    Given Trello's home page
    When I logged as a owner
    And I was create a new board
    And I add new list into board
    Then I should see the list