#Author: laxmi.sisode@geminisolutions.com
#Keyword: Appraisal Management

Feature: AppraisalManagement

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage


  Scenario:  Navigate to Add goal page
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    And Verify financial year dropdown
    Then Verify Add new KPI-KRA mapping button


  Scenario: Verify export button functionality
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Given Verify button is enabled and clickable
    Then Click on Excel option and check excel file is downloaded
    Then Click on PDF option and check pdf file is downloaded

  Scenario: Verify searches
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    When Verify search entries count at bottom
    When Type text in searchbox and verify search results
    Then Clear text and verify original count at the bottom of the table

  Scenario: Add new KPI/KRA mapping in add goal window
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    Given Click on Add new KPI-KRA mapping button
    Then Click on a close button
    Then Verify Add goal window
    And Click on Add new KPI-KRA mapping button
    Then Click on a submit button
    Then Check validation for KRA textbox
    Then Validate and click add KPI button
    When Click on a submit button
    Then Check validation for KPA textbox
    And Enter KRA in textbox
    And Enter KPI description in text box
    Then Click on a submit button
    And Check validation for empty Goal type Dropdown
    Then Select any one option from Goal Type Dropdown
    Then Validate and click add KPI button
    Then Click on close button of newly added KPI
    Then Click on a submit button
    Then Verify Success Popup appeared on screen and click on Ok button

  Scenario: Verify page navigation
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Then Verify the Pagination list
    And click on each page and check navigation

  Scenario: Check delete with remark and without remark
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Given Check if delete button is present in Action tab and Click on Delete button
    And Check remarks pop up is displayed and Click on submit button
    Then verify the validation
    Given Check if delete button is present in Action tab and Click on Delete button
    Then Type remark in textbox and click on submit button
    And Validate confirm window and Click on confirm button

  Scenario Outline: Click on draft without filling any fields
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    When Click Add or Update Goals
    Then Click on plus sign in Actions column
    And Select KPI from Dropdown
    Then Click on Draft button and Verify empty fields
    Then Add Project details in textbox '<ProjectName>'
    And Add Goal Description in textbox '<GoalDescription>'
    Then Click on Draft button
    Then Validate success window and click on ok button
    Examples:
      | ProjectName | GoalDescription |
      | TestProject | TestGoal        |

  Scenario Outline: Verify adding data in each field
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    When Click Add or Update Goals
    Then Click on plus sign in Actions column
    And Select KPI from Dropdown
    Then Click on Draft button
    Then Add Project details in textbox "<ProjectName>"
    And Add Goal Description in textbox '<GoalDescription>'
    Then Click on Draft button
    Then Validate success window and click on ok button
    Examples:
      | ProjectName | GoalDescription |
      | TestProject | TestGoal        |

  Scenario: Submit Goals
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Then Verify and click on Submit Goal button

  Scenario:Verify column sorting working or not
    When Click on Appraisal Management link
    Then Click on Add Goals link
    Then Verify Add goal window
    And Verify My Goal tab
    Then Click on Each column of first row and check the column is sorted