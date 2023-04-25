Feature: Contact Us form submission

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: Submitting details through Contact Us form
    Given I have launched the browser and navigated to the URL
    And I click on the 'Contact Us' button
    Then I should see the 'GET IN TOUCH' section
    And I should be able to enter my name, email, subject, and message
    And I should be able to upload a file if necessary
    Then I should be able to click the Submit button
    And I should see an OK button
    When I click on the OK button
    Then I should see the success message 'Success! Your details have been submitted successfully.'
    And I should be able to click the Home button
    And I should be taken back to the home page successfully

