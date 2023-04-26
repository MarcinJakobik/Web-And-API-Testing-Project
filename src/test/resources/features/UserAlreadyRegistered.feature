Feature: Register User with Existing Email
  As a user
  I want to register with my name and email address
  So that I can access the website

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: User tries to register with an existing email address
    Given I have launched the browser and navigated to the URL
    And I click on the Signup button
    Then I should see 'New User Signup!' displayed on the page
    When I enter my name and an already registered email address
    And I click the 'Signup' button
    Then I should see the error message 'Email Address already exist!' displayed on the page
