# Badger Bytes // Web And API Testing Project

This repository contains work from "Badger Bytes" a group created within Sparta Global's **March '23 JAVA SDET** training course.

This project involves testing the website and API <https://automationexercise.com/>, which has been specifically created for practising automation testing. The objective of the project is to analyze the website's functionality and create our own test cases for various API endpoints. By creating a testing framework we want to help future testers efficiently test the site using our framework.

## Main Objectives

- High quality user stories and test cases
- Fully functional API test framework using Service Object Model/Rest Assured
- Fully functional test framework using POM pattern
- Gherkin scenarios that represent the user journeys
- Defect reports
- Web Testing and Exploratory Test Charters during Phase 2

## User Stories

The user stories are written from the perspective of different types of users, such as a customer or an automation tester. Each user story describes a specific action that the user wants to perform on the website and the reason for performing that action.

```md

"AS an automation tester, I WANT to retrieve the product list,
SO THAT product data can be presented on a website later"

"AS an automation tester, I WANT to retrieve a list of brands, 
SO THAT later, a website can list brands it stocks" 

"AS an automation tester, I WANT to submit a brand name to the brandsList endpoint, 
SO THAT I can be sure it doesn't accept PUT requests" 

"AS an automation tester, I WANT to submit a search request with a parameter, 
SO THAT I am sure search results can be retrieved and can be presented on a website later" 

"AS an automation tester, I WANT to post new user account data to the /createAccount endpoint,
 SO THAT I am sure users will be able to register"

```

## Sample Acceptance Criteria (Gherkin Script)

```md

Scenario: Testing the product list is populated and exists.

HAPPY Path:

GIVEN, The productList endpoint exists
WHEN, I submit a GET request to the /productsList endpoint
THEN, the status code should be 200
AND I should receive a response containing the productList (which may or may not be empty)

SAD Path:

GIVEN, The productList endpoint does not exist
WHEN, I submit a GET request to the /productsList endpoint
THEN, the status code should be 404
AND I should receive a response message that the requested resource cannot be found
```

## Project Structure

The project is divided into two sprints: API and web implementation. The API sprint will focus on testing the website's API, while the web implementation sprint will focus on testing the website's user interface. The goal of the project is to develop a test automation suite that covers the website's functionality and ensure that it is working as intended.

The project contains two main directories: API and Web Implementation. The API directory contains test cases for testing the website's APIs, while the Web Implementation directory contains test cases for testing the website's user interface. Each directory contains its own set of user stories and test cases.

## Our Process

This project was completed over 2 days. We were given a site with various API tests to perform. We developed user stories from this, we used a Jira board to plot our product backlog items. We then used TDD and pair programming to continually develop features. During the sprints, we met in the afternoon to discuss current progress and then we would collectively assign programming-pairs to their backlog tickets. We ended our sessions with retros to talk about any blockers, update the Kanban board and to delegate tasks for the next day.

The project aims to apply SOLID and OOP principles and uses well-known design patterns. We developed the application in a TDD approach (JUnit / Maven). We used log4j2 for appropriate runtime logging and applied exception handling where applicable.

## Test Cases

The test cases are created based on the user stories. Each test case is designed to test a specific functionality of the website and ensure that it is working as intended. The test cases are organized by user story and are written in a format that includes the test case ID, name, objective, steps, expected result, test data, test environment, and pass criteria.

## Contributors

- [Nicholas Daily](https://github.com/@NicholasDaily) // Scrum Master for Phase 2
- [Edward Bradbury](https://github.com/@edwardbradbury) // Scrum Master for Phase 1
- [Marcin Jakobik](https://github.com/@MarcinJakobik) // Github Lead
- [Onur Belek](https://github.com/@Eluented)
- [Liam Richardson](https://github.com/@LRichardson-git)
- [Omar Hussain](https://github.com/@OmarHussain01)
- [Reggie Howard](https://github.com/@Reg-Howard)
- [Hamza Kazi](https://github.com/@HamzaKazi)
- [Muhammad Rizwan](https://github.com/@usmanrizwan1)
