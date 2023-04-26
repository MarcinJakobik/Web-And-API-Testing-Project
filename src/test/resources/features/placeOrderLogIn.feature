  Feature: logging in before checking out

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

    Scenario: Log in before checking out my cart
    #Scenario: Create a Account to log into first
    Given I am on the Homepage
    And I have Navigated to the Login Signup Page
    When I  put in my inital details and continue
    And  I  put in my Full Details
    Then I  have created an account
    And I have verified I am logged in
    And I Logout of my account
    #logout of the account and log back in
    Given I go to the homepagee
    And I have Navigated to the Login Signup Page
    Then I Will Enter my login details
    And I Check I am logged in (alternate)
    #Add products to cart
    Given I am on the Homepage
    And I add a product to the cart
    Then I will go to the cart
    #checkout cart
    Given I am on the cart page
    When I click the proceed to checkout button
    And I have entered my payment details
    And I verified the order was a success
    Then I click the delete account button
    And my account should be deleted