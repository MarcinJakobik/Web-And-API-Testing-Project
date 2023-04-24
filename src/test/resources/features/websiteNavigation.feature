Feature: As a User, I want to be able to navigate the Hacker News Website

  Background: Starting from the Home page
    Given I am on the Hacker News website

  Scenario: Navigating to the Comments page from the Home page
    When I click on the Comments link
    Then I will go to the Comments page

  Scenario: Navigating to the Past page from the Home page
    When I click on the Past link
    Then I will go to the Past page

#  Scenario Outline: unregistered user with testCases
#    Given I am on the LoginPage
#    When I enter "<username>" into the username box
#    And I enter "<password>" into the password box And I click the login button
#    Then I will see the message "Bad login."
#    Examples: | username | password | | Cathy | potato | | C@thy | fish |