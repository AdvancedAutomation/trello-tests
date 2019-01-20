@wip
Feature: Change Language in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"

  Scenario: change language Español
    When I go to member menu
    And I change language to "Español"
    Then I should see the page in "Español"

  Scenario: change language English
    When I go to member menu
    And I change language to "English (US)"
    Then I should see the page in "English (US)"
