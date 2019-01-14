@bvt
Feature: Edit list name

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title      | Team Board |
      | Privacy    | private    |
      | Background | green      |
    When I add new list into board
      | Name | To Do |
    Then I should see the list
  Scenario: As a user owner logged into trello's home page edit list name
    When I select and edit the list
      | Name | new name