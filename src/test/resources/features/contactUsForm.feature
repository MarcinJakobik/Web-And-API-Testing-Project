Feature: As a Tester, I want to be able to send a contact message,
  So that I can confirm that messages will send successfully.

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: Navigate to the Contact Us page
    When I click on the Contact Us link
    Then I will go to the Contact Us page
      And I will see the Contact Us Form

  Scenario:
    When I click on the Contact Us link
      And I enter the contact form details
      And I click the Submit button
      And I click the OK button
    Then I will see the Success message

  Scenario:
    When I click on the Contact Us link
      And I click on the Home Page link
    Then I will see the Home Page