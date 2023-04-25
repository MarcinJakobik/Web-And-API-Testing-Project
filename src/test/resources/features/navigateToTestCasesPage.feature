Feature: As a tester I WANT to be able to navigate to the Test Cases page

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: I navigate to the Test Cases page
    Given I am on the homepage
    When I click the Test Cases button
    Then I should be directed to the test_cases page