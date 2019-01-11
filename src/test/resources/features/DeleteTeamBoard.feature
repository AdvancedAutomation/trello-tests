@wip
Feature: Delete team board

  Background:
    Given I Log in with user "{credentials.owner1}"
    When I create a team with a:
      | Name        | {dateTime.Team01} |
      | Description | any               |
    And I create a team board:
      | Title | New Board |

  Scenario: I delete a board to team
    And I close Board
    And I delete Board
    Then I don't should see the board "New Board"
