Feature: Adding Products to Cart

  Background:Adding two products to cart and verifying their prices, quantity and total price
    Given I am on the home page

  Scenario:Navigating to product page
    When I click products button
    Then I am redirected to product page

  Scenario:Adding two product to cart
    When I add product to the cart
    And I click continue shopping button
    And I add second product to the cart
    And I click continue shopping button
    Then two product should be in the cart

  Scenario: Verifying products prices, quantity and total prices
    When I go to cart
    And products are in the cart
    Then I check if price, quantity and total price is correct