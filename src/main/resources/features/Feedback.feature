Feature: Feedback Feature - MIS Automation GemJar

  Background: : : The user is on MIS Homepage and logs in
    Given User is on the MIS Login Page
    When User enters their login details "touqeer.subhani" and "Gemini@123" and logs in
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