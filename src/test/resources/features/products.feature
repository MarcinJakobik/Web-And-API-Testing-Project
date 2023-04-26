Feature: As a USER, I want to view products for sale on the Automation Exericses website

  Background: Starting from the homepage
    Given I am on the Automation Exercise Website

  Scenario: Viewing all products for sale
    Given I am on the Automation Exercise homepage
    When I click on the Products button
    Then the products list is visible

  Scenario: Viewing details of a product
    Given I am on the Products page
    When I click on the view product button for the first product
    Then then I see a page with details about the product

  Scenario: Searching for a product
    Given I am on the Products page
    When I enter a product name and click search button
    Then the text SEARCHED PRODUCTS is visible
    And all products related to search are visible