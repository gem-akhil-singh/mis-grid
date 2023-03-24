#Author: tushar.chauhan@geminisolutions.com
#Keyword: Other Portals

Feature: Others Portal functionality 

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario Outline: Others Portal: Link navigation check for all portals
    Given Click on Other Portals
    When Select portal <portal> from dropdown
    Then Validate Navigation to portal URL <url> and <portal>
    Examples:
      | portal          | url                                             |
      | Athena          | https://athena.geminisolutions.com/login|
      | Contripoint     | https://contripoint.geminisolutions.com/#/login|
      | Gembook         | https://gembook.geminisolutions.com/#/|
      | Gem Wiki        | https://wiki.geminisolutions.com/login|
      | Github          | https://github.com/Gemini-Solutions|
      | Hiring Pipeline | https://hpipe.geminisolutions.com/#/login|
      | Jenkins         | https://jenkins.geminisolutions.com/|
      | L&D Portal      | https://geminisolutions.talentlms.com/index|