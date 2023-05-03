# Badger Bytes // Web And API Testing Project

This repository contains work from "Badger Bytes" a group created within Sparta Global's **March '23 JAVA SDET** training course.

The objective of the project is to create a testing framework for: API calls and a website's functionality. By creating this framework, we want to help other testers efficiently test the site using our framework. We tested the website and API <https://automationexercise.com/>, a site created for practising automation testing. The project was completed in two phases: "API testing" and "web testing".

## Learning Objectives

- API testing framework using Service Object Model (eschewing RestAssured)
- Web testing framework using POM pattern
- Defect reports
- Web testing led by BDD and TDD
- Creating "StepDefs" to track and test user journey's from Cucumber scripts
- Utilising Selenium WebDriver
- Create an exploratory Test Charter

## User Stories

i.e. What was tested?

The API testing framework tests for specific API calls on differing endpoints to check the expected response codes and messages. To do this, we were often checking if certain JSON data was present and parsing the JSON into Java objects that could be tested on. Meanwhile, the web testing framework has test cases for functionality/features that users would expect and ensure that they're working as intended.

Here's a small sample of the user stories we used to derive our tests.

### Sample User Stories // API

```md

"AS an automation tester, I WANT to retrieve the product list,
SO THAT product data can be presented on a website later"

"AS an automation tester, I WANT to submit a search request with a parameter, 
SO THAT I am sure search results can be retrieved and can be presented on a website later

```

### Sample User Stories // Web

```md

"AS a new user who wants to create an account, I WANT to be able to register with my personal information,
SO that I can access the features"

"AS a registered user, I WANT to be able to register while I checkout my cart,
SO that I can order my items"
```

## Acceptance Criteria (Gherkin Syntax)

### Sample Acceptance Criteria // API

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

### Sample Acceptance Criteria // Web

```md

Scenario: Input email address on the home page and submit to sign up to the Mailing List.

GIVEN, I am on the home page      
WHEN, I enter my email address      
AND, I click the arrow button      
THEN a success message 'You have been successfully subscribed!' will be visible   

```

## Test Metrics

- API Call Tests:
  - 100% coverage of each item on the websites API Test list.

- Website Functionality Tests:
  - 17 / 26 Test cases covered, 15 passed.
  - Successfully tested 65% of cases provided by the site.

- Cucumber Features:
  - 17 features containing 29 scenarios.
  - 27 / 29 scenarios passed = 93%%.

## Project Structure And Installation

1. Fork this repository and then clone the forked repo to your local machine.
2. Open the project in your preferred IDE.
3. Download the correct driver for your browser of choice.

- e.g. If using Chrome, check your version of Chrome and Download the corresponding ChromeDriver on https://chromedriver.chromium.org/downloads

4. Copy and paste the Driver application into this folder: `Web-And-API-Testing-Project/src/test/resources/`
5. Open the `WebTesting.properties` file in the same `/resources` folder.
6. In `WebTesting.properties` ensure that the driver you are using is the **only** driver that is "un-commented". If using Chrome, skip this step as Chrome is the default driver.

- e.g If you are using Firefox, comment out `driver=chrome` and "un-comment" `driver=firefox`.

7. Call `DriverFactory.getDriver()` from the `src/test/java/com/sparta/badgerBytes/webTesting/pom/util` folder and pass it to the constructor of the `HomePage` class in `src/test/java/com/sparta/badgerBytes/webTesting/pom/pages`
8. Rebuild your project in the IDE.

There are two main directories: apiTesting and webTesting. The API directory contains test cases for the site's API, while the Web Implementation directory contains test cases for testing the website's user interface. Each directory contains its own user stories and test cases.

## Our Process

This project was completed over 4 days total with 2 days for each phase. There were 8 'sprints' in total. We started with the API, developing user stories from the site and then we used a Jira board to plot our product backlog items. We then used TDD (Junit / Maven) and pair programming to continually develop features. We followed this same methodology in phase 2, except we derived our test cases from the the list given to us on the site. We also followed BDD more explicitly in phase 2 with Cucumber to better integrate with Selenium WebDriver.

During the sprints, we met in the mornings/afternoons to discuss progress and then we would collectively assign programming-pairs to their backlog tickets. We ended our sessions with retro's to talk about any blockers, update the Kanban board and delegate tasks for the next day.

The project applies SOLID and OOP principles and uses well-known design patterns where appropriate. We used log4j2 for runtime logging and applied exception handling where applicable.

## Contributors

- [Edward Bradbury](https://github.com/edwardbradbury) // Scrum Master phase 1
- [Nicholas Daily](https://github.com/NicholasDaily) // Scrum Master phase 2
- [Marcin Jakobik](https://github.com/MarcinJakobik) // Github Lead
- [Elliott Horton-Stephens](https://github.com/ells101)
- [Onur Belek](https://github.com/Eluented)
- [Liam Richardson](https://github.com/LRichardson-git)
- [Omar Hussain](https://github.com/OmarHussain01)
- [Reggie Howard](https://github.com/Reg-Howard)
- [Hamza Kazi](https://github.com/HamzaKazi)
- [Muhammad Rizwan](https://github.com/usmanrizwan1)
