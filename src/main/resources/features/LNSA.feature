Feature: LNSA Feature - MIS Automation GemJar

  Background: : : The user is on MIS Homepage and logs in
    Given User is on the MIS Login Page
    When User enters their login details "touqeer.subhani" and "R2VtaW5pQDEyMw==" and logs in
    Then User clicks on LNSA from left menu panel

  Scenario: User clicks on the Previous and Next Buttons from Apply LNSA page
    And User selects Apply LNSA from menu panel
    Then User tries to move to the previous date
    Then User tries to move to the next date

  Scenario: User selects any week using the checkboxes on Apply LNSA page
    And User selects Apply LNSA from menu panel
    Then User checks and unchecks a checkbox of any week present on the page
    And User tries to Submit the LNSA without selecting date

  Scenario: User selects a day and Submits the LNSA
    And User selects "Apply LNSA" from menu panel
    Then User selects a day for which LNSA has not been applied
    Then User submits the LNSA with selected day
    And User enters the reason for LNSA submission
    Then User clicks on the "Submit" of Reason pop-up
    Then User verifies the success message and clicks on OK

  Scenario: User selects a day and clicks on the cacel button
    And User selects Apply LNSA from menu panel
    Then User selects a day for which LNSA has not been applied
    Then User submits the LNSA with selected day
    And User enters the reason for LNSA submission
    Then User clicks on the "Cancel" of Reason pop-up

  Scenario: User navigates to the View Request Status option of LNSA page and checks th Export functionality
    And User selects "View Request Status" from menu panel
    Then User checks if the Export button is available
    And User clicks on the Export button

  Scenario Outline: User searches for LNSA entries using keyword <search entry> on the View Request Status of LNSA page
    And User selects "View Request Status" from menu panel
    Then User enters "<search entry>" in the search box
    And User checks if "<search entry>" is in search result of LNSA applied

    Examples:
      | search entry |
      | reason       |
      | help         |