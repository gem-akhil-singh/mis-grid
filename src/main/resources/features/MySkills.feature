Feature: MySkills Automation

  Background: User is on  Login Page
    When User enters username as "shruti.singh"
    And User enters password as "Gemini@123"
    Then User clicks on sign in
    And User verifies landing page


  Scenario Outline: Verify my skills are updating with valid data
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

    ###########Failed Scenario as skills will not be updated with invalid data ###############
  Scenario Outline: Verify my skills are updating with in invalid data
    When User clicks on user image button
    Then User clicks on skills button
    Then User clicks on technology dropdown
    Then User selects the professional level as "<professionalLevel>"
    And User enters the tech experience "17"
    And User enters the total experience "48"
    When User clicks on skill save button
    Then User scrolls to skills view
    And Skills are updated with "<mySkills>"
    Then User clicks on close button

    Examples:
      | professionalLevel | mySkills   |
      | Beginner          | Accounting |