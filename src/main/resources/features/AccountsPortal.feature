#Author: smita.mishra@geminisolutions.com
#Keyword: AccountPortal

Feature: AccountsPortal

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage


  Scenario Outline: Verify elements loaded on My Account page
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    And Verify new tab is open "greytHR IDP"
    Then Verify greytHR logo is present on the current page
    And Verify Gemini logo is present on the current page
    And Verify "<greytHR username text>" field is present on the current page
    And Verify "<gerytHR password text>" field is present on the current page
    And Verify Hello there! text is present on the current page
    And Verify login button is present on current page
    And Verify forget password link is present on current page
    Examples:
      | greytHR username text | gerytHR password text |
      | Login ID              | Password              |

  Scenario Outline: Verify log in failed when no credentials are enter
    Then Click "My Account" sub-tab inside "Accounts Portal" tab
    And Verify new tab is open "greytHR IDP"
    Then Click on login button without entering username and password
    And Verify "<Message>" text is present on the current page
    Examples:
      | Message                            |
      | Username and password is required. |


