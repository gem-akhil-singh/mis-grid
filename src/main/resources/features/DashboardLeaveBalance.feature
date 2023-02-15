Feature: Dashboard_Leave_balance

  Background: Login
    Given User should be on MIS login page and enter smita.mishra and Gemini@123
    When Click on submit button
    Then User should be navigated to MIS homepage

  Scenario: Verify leave Balance card is visible or not
    Then Verify leave balance section is present on the current page

  Scenario: Verify leave history popup window
    Then Verify leave balance section is present on the current page
    And Click on number of leaves
    And Verify leave history popup should be open


