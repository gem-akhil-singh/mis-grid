Feature: Automation of MIS Portal functionality

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then Validate login successful


  Scenario Outline: MIS: Other Portals Automation
    Given Click on Other Portals
    When Select portal <portal> from dropdown
    Then Validate Navigation to portal URL <url> <portal>
    Examples:
      | portal      | url                                             |
      | Athena      | https://athena.geminisolutions.com/login        |
      | Contripoint | https://contripoint.geminisolutions.com/#/login |
      | Gembook     | https://gembook.geminisolutions.com/#/          |