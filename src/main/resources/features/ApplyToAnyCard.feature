#Author: charu.garg@geminisolutions.com
#Keyword: Apply to any card

Feature: Dashboard-Apply To Any Card

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Dashboard-Apply To Any Card: Verify minimize functionality
    When Check "Referral" card is present in dashboard
    And User clicks on "minimize" button on "Referral" card on dashboard
    Then Verify that "Referral" card is minimized on dashboard

  Scenario: Dashboard-Apply To Any Card: Verify fullscreen functionality
    When Check "Referral" card is present in dashboard
    And User clicks on "maximize" button on "Referral" card on dashboard
    Then Verify that "Referral" card is maximized on dashboard

