#Feature: Delete board in Trello
#
#  Background:
#    Given I Log in with user "{credentials.owner1}"
#    And I create a dashboard with a:
#      | Title      | abc1    |
#      | Privacy    | private |
#      | Background | green   |
#  Scenario: I delete a board as owner user
#    Given Open de Board:
#      | Title      | abc1    |
#    And Close Board.
#    Then Then I don't should see the board.