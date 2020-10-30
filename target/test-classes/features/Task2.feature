Feature: Task 2- Testing the functionality of the people page
  I have to be able to add a new person, edit a person, remove a person, reset the original list and to
  confirm that the clear button works

  Background:
    Given I am on the people page

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