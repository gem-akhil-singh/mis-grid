#Author: tushar.chauhan@geminisolutions.com
#Keyword: Timesheet

Feature: Automating Timesheet Scenarios MIS

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario Outline: MIS: Validate Timesheet Table Headers
    Given Click on Timesheet
    When Click on Timesheet option as <timesheet>
    Examples:
      | timesheet            |
      | Configure Timesheet  |
      | Create Timesheet     |
      | Manage Task Template |

  Scenario Outline: MIS: Validate incorrect value Timesheet Table Headers
    Given Click on Timesheet
    When Fail click on Timesheet option as <timesheet>
    Examples:
      | timesheet |
      | Time      |