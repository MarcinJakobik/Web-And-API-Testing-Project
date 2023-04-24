Feature: As a USER, I want to subscribe to the mailing list on the cart page of www.automationexercise.com

  Background: Starting from the home page
    Given I am on the automation exercise website

  Scenario: Finding the mailing list
    When I click on the Cart button
    And I look down at the footer
    Then I see the text SUBSCRIPTION

  Scenario: Input email address and submit
    When I enter my email address
    And I Click the arrow button
    Then the success message is visible