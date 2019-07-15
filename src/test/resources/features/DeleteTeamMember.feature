@wip
Feature: Delete team member

  Background:
    Given I Log in with user "{credentials.owner1}"
    And I create a team with a:
      | Name        | {dateTime.Team01} |
      | Description | any               |
    And I select tab members
    And I invite a member to the Team:
      | "{credentials.member1}" |

  Scenario: Delete Team Member
    When I delete the team member:
      | Name | "{credentials.member1}" |
    Then I didnt see the member in the list
      | Name | "{credentials.member1}" |
