Feature: As a USER, I want to subscribe to the mailing list from the cart on the Automation Exericses website

  Background: Starting from the shopping cart
    Given I am on the automation exercise website shopping cart

  Scenario: Finding the mailing list subscription form on shopping cart page
    When I look at the shopping cart footer
    Then I see the text SUBSCRIPTION in the shopping cart footer

  Scenario: Subscribing to the mailing list from shopping cart
    When I enter my email address in the mail subscription form in the shopping cart
    And I Click the arrow button in the email subscription form in the shopping cart
    Then the success message is visible in the email subscription form in the shopping cart