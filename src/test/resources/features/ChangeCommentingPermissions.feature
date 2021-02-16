@wip
Feature: Change Commenting permissions to Board

  Background:
    Given I Log in with user "{credentials.owner3}"
    And I create a board from "board drawer" with a:
      | Title | Board Targaryen |

  Scenario: Change Commenting permissions to Board
    When I go to board settings
    And I change commenting permissions to "Disabled"
    Then I should see the commenting permissions is "Disabled"
