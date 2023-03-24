#Author: divya.madan@geminisolutions.com
#Keyword: Referral Feature

Feature: MIS - Referral feature

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Referral: Verify if dashboard page is loaded properly and JD window is visible
    When Verify dashboard page is loaded properly
    Then Verify JD window is visible

  Scenario: Referral: Validation of referral creation
    When User checks referral section
    And User click on referral action
    And Click on name under referral
    And Enter the correct email
    And Enter the correct contact number

  Scenario: Referral: Validation of wrong email pop up
    When User checks referral section
    And User click on referral action
    And Click on email under referral
    And Enter the email address
    And Click on save
    Then Verify the warning message in ref section

  Scenario: Referral: Validation of wrong format upload pop up
    When User checks referral section
    And User click on referral action
    And User enter details and upload file
    Then Verify wrong format is uploaded

  Scenario: Referral: Validation of FAQ pdf visibility
    When User checks referral section
    And Click on FAQ
    Then Verify the pdf is visible

  Scenario: Referral: Validation of manual pdf visibility
    When Click on Manual
    Then Verify the manual is visible





