Feature: Organization Structure Module Scenarios


  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then Validate login successful

  Scenario Outline: Search for Employee with Designation
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Validate availability of Employee <empname> and Designation <designation>
    Examples:
      | empname        | designation             |
      | Tushar Chauhan | Software Engineer L2    |
      | Vishal Malik   | Chief Executive Officer |


  Scenario Outline: Search for Employee with Incorrect Designation
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Validate unavailability of Employee <empname> and Designation <designation>
    Examples:
      | empname        | designation             |
      | Tushar Chauhan | Software Engineer L1    |

  Scenario: Search for all the the employees visible first time
    Given Navigate to Organization Structure
    Then Count number of senior visible

  Scenario Outline: Zoom-in to employee card through double click
    Given Navigate to Organization Structure
    When Entered employee name <empname> in search field
    Then Double click on employeecard <empname>
    Examples:
      | empname        |
      | Tushar Chauhan |
      | Shubham Kumar  |