#Author: tushar.chauhan@geminisolutions.com
#Keyword: Organization Structure

Feature: Organization Structure Module Scenarios


  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario Outline: Organization Structure: Search for Employee with Designation
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Validate availability of Employee <empname> and Designation <designation>
    Examples:
      | empname        | designation             |
      | Tushar Chauhan | Software Engineer L2    |
      | Vishal Malik   | Chief Executive Officer |


  Scenario Outline: Organization Structure: Search for Employee with Incorrect Designation
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Validate unavailability of Employee <empname> and Designation <designation>
    Examples:
      | empname        | designation             |
      | Tushar Chauhan | Software Engineer L1    |

  Scenario: Organization Structure: Search for all the the employees visible first time
    Given Navigate to Organization Structure
    Then Count number of senior visible

  Scenario Outline: Organization Structure: Zoom-in to employee card through double click
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Double click on employeecard <empname>
    Examples:
      | empname        |
      | Tushar Chauhan |
      | Shubham Kumar  |