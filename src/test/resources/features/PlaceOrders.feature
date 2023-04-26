Feature: As, a User I want to Place an Order

  Background: Starting from the Home page
    Given I am on the Automation Exercise Website

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

    Scenario: Register before I checkout my order
      Given I am on the Homepage
      And I have Navigated to the Login Signup Page
      When I  put in my inital details and continue
      And  I  put in my Full Details
      Then I  have created an account
      And I have verified I am logged in
      #scenario add products and goTO cart
      Given I am on the Homepage
      And I add a product to the cart
      When I click on the cart
      Then I am on the cart page
      And have items in the cart
      ##Checkout while already logged in and delete account
      Given I am on the cart page
      When I click the proceed to checkout button
      And I have entered my payment details
      And I verified the order was a success
      Then I click the delete account button
      And my account should be deleted

  #here to create an account since need one
  Scenario: Create a Account
    Given I am on the Homepage
    And I have Navigated to the Login Signup Page
    When I  put in my inital details and continue
    And  I  put in my Full Details
    Then I  have created an account
    And I have verified I am logged in




  Scenario: Log in before checking out my cart
    Given I am on the Homepage
    And I have Navigated to the Login Signup Page
    Then I Will Enter my login details
    And I Check I am logged in (alternate)
        #Add products to cart
    Given I am on the Homepage
    And I add a product to the cart
    Then I will go to the cart
        ##checkout cart
    Given I am on the cart page
    When I click the proceed to checkout button
    And I have entered my payment details
    And I verified the order was a success
    Then I click the delete account button
    And my account should be deleted
