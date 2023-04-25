Feature: As a tester I WANT to be able to access individual brand product pages

  Background: Starting from the homepage

  Scenario: verification of brand side bar feature from home page
    Given I am on the home page
    When I click on the KOOKIE KIDS button
    Then I should be directed to the Kookie Kids product page
    And I should see all of the KOOKIE KIDS products

  Scenario: verification of brand side bar feature from a specific brand product page
    Given I am on the Kookie Kids product page
    When I click on the BABYHUG button
    Then I should be directed to the Babyhug products page
    And I should see all of the Babyhug products