Feature: Task 2- Testing the functionality of the people page
  I have to be able to add a new person, edit a person, remove a person, reset the original list and to
  confirm that the clear button works

  Background:
    Given I am on the people page

  Scenario Outline: Testing adding people
    When I click: add
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click the add button
    Then I should see: "<name>","<job>"
    Examples:
      |name |job|
      |Chris|dev|

  Scenario Outline: Changing number of people and deleting
    When I click: "<action>" "<times>" times
    Then I should see: "<number>" people
    Examples:
      |action|number|times|
      |add   |4     |1    |
      |delete|2     |1    |
      |add   |5     |2    |
      |delete|1     |2    |


  Scenario Outline: Testing the ability to edit
    When I click: edit
    And I clear the boxes
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click the edit button
    Then I should see edited: "<name>","<job>"
    Examples:
      |name |job|
      |Chris|dev|

  Scenario Outline: Reset button test-delete and restore new values
    When I click: "<action>" "<times>" times
    And I click the restore button
    Then I should see: "<number>" people
    Examples:
      |action|number|times|
      |add   |3     |1    |
      |delete|3     |1    |


  Scenario Outline: Reset button restores original text
    When I click: edit
    And I clear the boxes
    And I enter person name: "<name>"
    And I enter person job: "<job>"
    And I click the edit button
    Then I should see edited: "<name>","<job>"
    When I click the restore button
    Then I should see edited: "<name1>","<job1>"
    Examples:
      |name |job|name1|job1        |
      |Chris|dev|Mike |Web Designer|