#Author: divya.madan@geminisolutions.com
#Keyword: DashboardProfile

Feature: MIS_Automation - Dashboard Profile

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Dashboard Profile: User enter invalid phone number
    When Click on edit details button
    And Enter mobile number
    Then Verify error message

  Scenario: Dashboard Profile: User enters invalid extension number
    When Click on edit details button
    And Enter extension number
    Then Verify error message

  Scenario: Dashboard Profile: User enter invalid pincode
    When Click on edit details button
    And Click on update address
    And Enter pinCode
    Then Verify invalid pincode

  Scenario: Dashboard Profile: User leaves Pin Code field blank
    When Click on edit details button
    And Click on update address
    And Click on pincode
    Then Verify pincode is blank

  Scenario: Dashboard Profile: User enters Incorrect Password
    When Click on edit details button
    And Click on change password
    And Enter old password
    Then Verify the the password is incorrect

  Scenario: Dashboard Profile: User enters Different Password in Confirm Password
    When Enter new password and confirm password
    Then Verify password not match

  Scenario: Dashboard Profile: User not fills a field in Change Password section
    When Click on edit details button
    And Click on change password
    And Click on update password
    Then Verify password is blank


  Scenario: Dashboard Profile: User applies for lunch
    When User click on apply lunch
    And User click on from date and click on select from date
    And User click on till date and select till date
    And Click on location container
    And Select the location from the list
    Then Click on add lunch button

  Scenario: Dashboard Profile: User applies for lunch for already applied date
    When User click on apply lunch
    And User click on from date and click on select from date
    And User click on till date and select till date
    And Click on location container
    And Select the location from the list
    And Click on add lunch button
    Then Verify the warning message


  Scenario: Dashboard Profile: User leave a field blank in Apply lunch
    When User click on apply lunch
    And User click on from date and click on select from date
    And User click on till date and select till date
    And Click on location container
    And Click on add lunch button
    Then Verify select is blank






