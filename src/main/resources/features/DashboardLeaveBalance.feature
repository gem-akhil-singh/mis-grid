#Author: smita.mishra@geminisolutions.com
#Keyword: Dashboard Leave Balance

Feature: Dashboard_Leave_balance

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Dashboard Leave Balance: Verify leave Balance card is visible or not
    Then Verify leave balance section is present on the current page

  Scenario: Dashboard Leave Balance: Verify leave history popup window
    Then Verify leave balance section is present on the current page
    And Click on number of leaves
    And Verify leave history popup should be open
