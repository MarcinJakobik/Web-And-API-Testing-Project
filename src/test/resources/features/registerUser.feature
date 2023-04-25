Feature: Register User
  Scenario: Registering a new user
    Given I have launched the browser and navigated to the URL 'http://automationexercise.com'
#    When I close the add by clicking on the 'close-button'
    And I click on the Signup / Login button
    Then I should see 'New User Signup!' displayed on the page
    When I enter my name and email address
    And I click the 'Signup' button
    Then I should see 'Enter Account Information' shown on the page
    And I fill in the required account information
    And I click the 'Create Account' button
    Then I should see 'Account Created!' displayed on the page
    And I click the 'Continue' button
    Then I should see 'Logged in as username' displayed on the page
    When I click the 'Delete Account' button
    Then I should see 'ACCOUNT DELETED!' displayed on the page
    And I click the 'Continue' button