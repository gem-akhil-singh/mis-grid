Feature: NavBar

#  Background: Login
#
#    Given User should be on MIS login page and enter smita.mishra and R2VtaW5pQDEyMw==
#    When Click on submit button
#    Then User should be navigated to MIS homepage
  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Verify toggle button on Dashboard Page
    Then Verify a toggle button is present on Dashboard and clickable

  Scenario Outline: Verify Update profile Section
    Then Click on Profile menu
    And Verify all the <Fields> and <Buttons> are present
    Examples:
      | Fields                                                                                                                                                  | Buttons      |
      | Update Profile:Mobile number,Extn. number;Update Address:Country,State,City,Pin code,Address;Change Password:Old Password,New Password,Confirm Password | Update,Close |

  Scenario: Verify user redirect to landing page when clicking on Gemini logo
    Then Click on Gemini logo
    And User should be navigated to MIS homepage

  Scenario Outline: Verify Add skill close button after entering all values
    Then Click on Skills menu
    And Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","<Tech Experience>","<Total Work Exp>"
    And Click on close button

    Examples:
      | Technology | Proficiency Level | Skill Type | Tech Experience | Total Work Exp |
      | Accounting | Beginner          | Secondary  | 24              | 2              |

  Scenario Outline: Verify Success Message box when adding new skills

    Then Click on Skills menu
    And Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","<Tech Experience>","<Total Work Exp>"
    And Click on Save button
    And Verify popup with message "<AlertType>" and "<Message>"

    Examples:
      | Technology | Proficiency Level | Skill Type | Tech Experience | Total Work Exp | AlertType | Message                             |
      | Scripting  | Beginner          | Secondary  | 24              | 2              | Success   | Skills has been saved successfully. |


  Scenario Outline: Verify Warning Message box when adding duplicate skills
    Then Click on Skills menu
    And Enter all the details "<Technology>","<Proficiency Level>","<Skill Type>","<Tech Experience>","<Total Work Exp>"
    And Click on Save button
    And Verify popup with message "<AlertType>" and "<Message>"

    Examples:
      | Technology | Proficiency Level | Skill Type | Tech Experience | Total Work Exp | AlertType | Message                       |
      | Accounting | Beginner          | Secondary  | 24              | 2              | Warning   | Duplicate Skills not Allowed. |

  Scenario: Verify New Tab should be open on Change AD Password button
    Then User click on Change AD Password and Verify new tab should be open

  Scenario: Logout to MIS portal
    Then Click on Logout menu
    And User navigate to login page

  Scenario Outline: Verify Experiences text field on Add new skills window
    Then Click on Skills menu
    And Enter experience"<techExp>" in TechExperience
    And Verify experience"<techExp>" of TechExperience
    Then Enter workExperience "<workExp>" in workExpField
    And Verify workExperience "<workExp>" of workExpField
    Examples:
      | techExp | workExp |
      | 24      | 2       |
      | twenty  | two     |

  Scenario: Verify cards are added on dashboard when updating from dashboard setting
    Then Click on Dashboard setting
    And Verify Dashboard setting table is visible on the current screen
    Then Verify all check boxes are uncheck
    And Click on Update button
    And Verify "no" card is shown on the dashboard

  Scenario: Verify all cards re appear when checked from dashboard setting
    Then Click on Dashboard setting
    And Verify Dashboard setting table is visible on the current screen
    Then Verify all check boxes are check
    And Click on Update button
    And Verify "all" card is shown on the dashboard

  Scenario Outline: Verify EC DC Hierarchy Popup
    Then Click on EC DC Hierarchy link
    And Verify EC DC Hierarchy popup should be open
    And Verify tab <tab> with columns <columnsname>

    Examples:
      | tab                 | columnsname                                                                                            |
      | Engineering Council | Engineering Council,Chair,Co-Chair,EC Teams Channel,EC Email,Governance Teams Channel,Governance Email |
      | Delivery Council    | Delivery Council,Sub Delivery Council,Chair,Co-Chair,HRBP,Associate HR,Teams Channel,Email Alias / DL  |

