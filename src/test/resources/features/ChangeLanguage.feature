@bvt
Feature: Change Language in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"

  Scenario: change language
    When I go to member menu
    And I change language to "Español"
    Then I should see the page in "Español"
