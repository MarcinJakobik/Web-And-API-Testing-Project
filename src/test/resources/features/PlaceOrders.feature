Feature: As, a User I want to Place an Order

  Background: Starting from the Home page
    Given I am on the Homepage

  Scenario: Add a product to the cart
    When I add a product to the cart
    Then I will go to the cart
    And see that the product has been added to the cart

  Scenario: Create an account on the checkout page
    Given I am on the cart page
    When I click the proceed to checkout button
    And Click on the create account button
    Then I will put in my Name andEmail Address
    And I will create a account
    And I have verified I am logged in

  Scenario: Order products on the cart Page
    When I click on the cart
    And have items in the cart
    Then click proceed to checkout button
    And I have entered my details
    And I verified the order was a success

  Scenario: Delete account on homepage
    When I click the delete account button
    And clicked the verify account deletion button
    Then my account should be deleted



