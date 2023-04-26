Feature: As, a User I want to Place an Order

  Scenario: Add a product to the cart
    Given I am on the Homepage
    When I add a product to the cart
    Then I will go to the cart
    And see that the product has been added to the cart

  #Scenario: Create an account on the checkout page
    Given I am on the cart page
    When I click the proceed to checkout button Register
    And I  put in my inital details and continue
    Then I  put in my Full Details
    And I  have created an account
    And I have verified I am logged in

  #Scenario: Order products on the cart Page
    When I click on the cart
    And have items in the cart
    Then click proceed to checkout button
    And I have entered my payment details
    And I verified the order was a success

  #Scenario: Delete account on homepage
    When I click the delete account button
    And clicked the verify account deletion button
    Then my account should be deleted



