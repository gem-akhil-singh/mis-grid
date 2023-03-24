#Author: shruti.singh@geminisolutions.com
#Keyword: My Skills

Feature: MySkills Automation

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage


  Scenario Outline: My-Skills : Verify my skills are updating with valid data
    When User scrolls to skills view
    And Skills are updated with "<mySkills>"
    Then User clicks on close button

    Examples:
      | mySkills   |
      | Accounting |

  Scenario Outline: My-Skills : Verify my skills are updating with in invalid data
    When User clicks on user image button
    Then User clicks on skills button
    Then User clicks on technology dropdown
    And User selects the "<technology>"
    When User clicks on professional dropdown
    Then User selects the professional level as "<professionalLevel>"
    And User enters the tech experience "17"
    And User enters the total experience "48"
    When User clicks on skill save button
    Then User clicks on skill ok button
    And User clicks on skill close button
    Then User scrolls to skills view
    And Skills are updated with "<mySkills>"
    Then User clicks on close button

    Examples:
      | technology | professionalLevel | mySkills   |
      | Accounting | Beginner          | Accounting |
