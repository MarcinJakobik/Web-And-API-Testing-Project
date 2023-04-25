Feature:

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: Login with Incorrect Email and Password
    Given I have launched the browser and navigated to the URL
    When I click on the 'Signup / Login' button
    Then I should see 'Login to your account' displayed on the page
    When I enter an incorrect email address and password
    And I click the 'Login' button
    Then I should see the error message 'Your email or password is incorrect!' displayed on the page
