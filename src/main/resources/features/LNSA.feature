Feature: LNSA Feature - MIS Automation GemJar

  Background: : : The user is on MIS Homepage and logs in
    Given User is on the MIS Login Page
    When User enters their login details "touqeer.subhani" and "Gemini@123" and logs in
    Then User clicks on LNSA from left menu panel

  Scenario: User clicks on the Previous and Next Buttons from Apply LNSA page
    And User selects Apply LNSA from menu panel
    Then User tries to move to the previous date
    Then User tries to move to the next date

  Scenario: User selects any week using the checkboxes on Apply LNSA page
    And User selects Apply LNSA from menu panel
    Then User selects a checkbox of any week present on the page
    And User tries to Submit the LNSA without selecting date