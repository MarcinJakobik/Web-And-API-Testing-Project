Feature: Successful Logout from Account
  Scenario: I am already signed in, and I want to log out
    Given I have launched the browser and navigated to the correct URL
    When I click on the correct Login button
    Then I should see Login to your account displayed on the page
    When I enter my correct email address and password
    And I click the Login button
    Then I should see Logged in as username displayed on the page
    When I click on the Logout button
    Then I should be navigated to the login page