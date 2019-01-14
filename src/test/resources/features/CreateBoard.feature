@wip
Feature: Create a Board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"

  Scenario: Create Board with board drawer
    When I create a board from "board drawer" with a:
      | Title      | abc1    |
      | Privacy    | private |
      | Background | green   |
    Then I should see the board

  Scenario: Create new Board with boards page
    When I create a board from "boards page" with a:
      | Title      | baco    |
      | Privacy    | private |
      | Background | red     |
    Then I should see the board

  Scenario: Create new Board with Icon add
    When I create a board from "quick add" with a:
      | Title      | Caio   |
      | Privacy    | public |
      | Background | red    |
    Then I should see the board
