Feature: As a USER, I want to subscribe to the mailing list from the Automation Exericses homepage

  Background: Starting from the home page
    Given I am on the automation exercise website

  Scenario: Finding the mailing list subscription form on home page
    When I look at the home page footer
    Then I see the text SUBSCRIPTION and an input form

  Scenario: Subscribing to the mailing list from home page
      When I enter my email address
      And I Click the arrow button
      Then the success message is visible

    # (can we automate a scroll?)
    # Exploratory: failure scenario mailing list?
