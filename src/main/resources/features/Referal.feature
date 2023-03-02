
Feature: MIS

  Background: Launch MIS url
    When user click on url
    And Enter username referal
    And Enter Password referal
    And click on SignIn button referal
    Then click on close button referal

    Scenario: Verify if dashboard page is loaded properly and JD window is visible
      When verify dashboard page is loaded properly
      Then verify JD window is visible

      Scenario: Validation of referral creation
        When user checks referral section
        And user click on referral action
        And click on name under referral
        And enter the correct email
        And enter the correct contact number

  Scenario: Validation of wrong email pop up
          When user checks referral section
          And user click on referral action
          And click on email under referral
          And enter the email address
          And click on save
          Then verify the warning message in ref section

          Scenario: Validation of wrong format upload pop up
            When user checks referral section
            And user click on referral action
            And user enter details and upload file
            Then verify wrong format is uploaded

          Scenario: Validation of FAQ pdf visibility
            When user checks referral section
            And click on FAQ
            Then verify the pdf is visible

          Scenario: Validation of manual pdf visibility
            When click on Manual
            Then verify the manual is visible





