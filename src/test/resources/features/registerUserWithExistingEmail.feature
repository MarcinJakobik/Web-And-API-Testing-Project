Feature: As a Tester, I want to be able to check registration of a user who has an existing email stored,
  So that I can confirm that the system will return an error message.

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: Navigate to the Login page
    When I click on the Signup And Login button
    Then I will go to the Login page
      And I will see the signup Form

  Scenario: Try registering with an existing email address
##    Given An account already exists
      And I click on the Signup And Login button
    When I enter a Name
      And I enter an already registered email address
      And I click the signup button
    Then I will see the error message

    # We could also test for existing username