Feature: Automating Timesheet Scenarios MIS

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then Validate login successful

  Scenario Outline: MIS: Validate Timesheet Table Headers
    Given Click on Timesheet
    When Click on Timesheet option as <timesheet>
    #Then Validate Table Headers and Rows
    Examples:
      | timesheet            |
      | Configure Timesheet  |
      | Create Timesheet     |
      | Manage Task Template |
      | Tushar               |