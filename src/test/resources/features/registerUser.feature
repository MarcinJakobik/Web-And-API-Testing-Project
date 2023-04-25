Feature: As a User I want to register and be able to delete my account
  Scenario: Registering a new user
    Given I have launched the browser and navigated to the URL
    And I click on the Signup button
    Then I should see 'New User Signup!' displayed on the page
    When I enter my name and email address
    And I click the 'Signup' button
    Then I should see 'Enter Account Information' shown on the page
    And I fill in the required account information
    And I click the Create Account button to create account
    Then I should see 'Account Created!' displayed on the page
    And I then click the 'Continue' button
#    And I close the add by clicking on the close button
    Then I should view logged in as username shown on the page
    When I click on the Delete Account button
    Then I should see account deleted displayed on the page
    And I click the Continue button