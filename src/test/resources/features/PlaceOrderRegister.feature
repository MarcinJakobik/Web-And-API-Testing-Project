Feature: Registering the user before checking out a order

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

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