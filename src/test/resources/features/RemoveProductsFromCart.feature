Feature: Remove Products From Cart

  Scenario: Remove product from cart
    Given I launch the browser
    When I navigate to the Homepage
    Then the homepage is displayed successfully

    When I add products to cart
    And I click the cart button
    Then the cart page is displayed successfully

    When I click the X button corresponding to a particular product
    Then the product is removed from the cart