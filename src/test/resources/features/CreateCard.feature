Feature: Create a Card in Trello

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a board from "board drawer" with a:
      | Title | Version |
    And I create another lists:
      | To do |

  Scenario: I create a card as owner user
    Given I create a card with a:
      | card1 |
    When I select the card:
      | listName | To do |
      | cardName | card1 |
    Then I should see the card "card1"
