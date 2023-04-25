Feature: As a registered user, I want to be able to login with my correct email address and password

  Scenario: Login with Correct Details
    Given I am on the Index Page
    When I press the login button
    Then I should see Login to your account displayed on the page
    When I enter my correct email and password
    And I click on the Login button
    Then I should see Logged in as username displayed on page
