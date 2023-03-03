Feature: Dashboard-Apply To Any Card

#  Background: Login
#    When User enters "username" as "charu.garg"
#    When User enters "password" as "R2VtaW5pQDEyMw=="
#    And Click on Sign In Button
#    Then Verify User is on "MIS Home" Page
  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Verify minimize functionality is working on any card in Beta Mis
    When Check "Referral" card is present in dashboard
    And User clicks on "minimize" button on "Referral" card on dashboard
    Then Verify that "Referral" card is minimized on dashboard

  Scenario: Verify fullscreen functionality is working on any card in Beta Mis
    When Check "Referral" card is present in dashboard
    And User clicks on "maximize" button on "Referral" card on dashboard
    Then Verify that "Referral" card is maximized on dashboard

