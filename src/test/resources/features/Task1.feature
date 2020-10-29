Feature: Task 1- Square root calculator test scenarios
  I have to be able to create sets of data to be used in the same test scenario outline

  Background:
    Given I am on the math page
  Scenario Outline: Error checking for incorrect data
    When I enter: "<value>"
    And I click the result button
    Then I see error message: "<string>"
    Examples:
    |value    |string                 |
    |trollis  |Please enter a number  |
    |48       |Number is too small    |
    |101      |Number is too big     |

  Scenario: Checking if valid number gives valid data
    When I enter: "64"
    And I click the result button
    Then I see the math message: "Square root of 64 is 8.00"