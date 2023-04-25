Feature: Multiple items in cart
  Background: Verifying product quantity in cart
    Given I am on the home page
    And I click products button

  Scenario: Adding 4 same products to cart
    When I add 4 units of the same product to cart
    And I go to cart
    Then Cart should have 4 same items
