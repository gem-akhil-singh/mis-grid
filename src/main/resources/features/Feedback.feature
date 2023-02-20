Feature: Feedback Feature - MIS Automation GemJar

  Background: : : The user is on MIS Homepage and logs in
    Given User is on the MIS Login Page
    When User enters their login details "touqeer.subhani" and "R2VtaW5pQDEyMw==" and logs in
    Then User clicks on Feedback from left menu panel
    When User clicks on Submit Feedback from the sub-menu option of Feedback

  Scenario: Submitting a feedback
    When User clicks on Provide Feedback button
    Then User enters the required comments
    And User clicks on Submit button
    Then User verifies the Success message and click on the OK button

  Scenario: User tries to navigate between the pages of Feedback page
    And User checks if the Next button is active
    Then User clicks on the "Next" button of Feedback page
    Then User clicks on the "Previous" button of Feedback page

  Scenario Outline: User searches for feedback entries using keyword <search entry> on the Feedback page
    Then User enters "<search entry>" in the search box
    And User checks if "<search entry>" is in search result

    Examples:
      | search entry |
      | feedback     |
      | help         |

  Scenario: User checks for the Export options available on Feedback page
    Then User checks if the Export button is available
    And User clicks on the Export button

  Scenario: User tries to view an existing feedback on Feedback Page
    Then User clicks on the View icon of the Feedback page
    And User verifies that the View Feedback pop-up appears