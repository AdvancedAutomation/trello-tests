@wip
Feature: Delete board in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | Stark Board |

  Scenario: I delete a board as owner user
    When I close Board
    Then The "Stark Board" board should be close
