#Author: divya.madan@geminisolutions.com
#Keyword: Referalfeature

Feature: MIS - Referalfeature

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

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





