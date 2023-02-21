@Dashtag
Feature: MIS_Automation

  #Background: These steps are common for every scenario
    #When User click on mislink
   # And User enter Username
   # And User enter password
    #Then User click on Sign In button


  Background: Launch MIS url
    When user click on url
    And Enter username
    And Enter Password
    And click on SignIn button
    Then click on close button

  Scenario: user enter invalid phone number
    When click on edit details button
    And enter mobile number
    And click on update mobile number
    Then verify invalid phone number

  Scenario: user enters invalid extension number
    When click on edit details button
    And enter extension number
    And click on update mobile number
    Then verify invalid ext number


  #Scenario: click on mobile details
   #When Enter mobile number and ext number
     # Then click on update

    ##  Scenario: user enter invalid pincode
        ##Given user click on url
      ##  When enter address in the update address tab

  Scenario:user enter invalid pincode
    When click on edit details button
    And click on update address
    And enter pinCode
    Then verify invalid pincode

  Scenario: user leaves Pin Code field blank
    When click on edit details button
    And click on update address
    And click on pincode
    Then verify pincode is blank

  Scenario: user enters Incorrect Password
    When click on edit details button
    And click on change password
    And enter old password
    Then verify the the password is incorrect

  Scenario: user enters Different Password in Confirm Password
    When enter new password and confirm password
    Then verify password not match

  Scenario: User not fills a field in Change Password section
    When click on edit details button
    And click on change password
    And click on update password
    Then verify password is blank


  Scenario:user applies for lunch
    When user click on apply lunch
    And user click on from date and click on select from date
    And user click on till date and select till date
    And click on location container
    And select the location from the list
    Then click on add lunch button

  Scenario: user applies for lunch for already applied date
    When user click on apply lunch
    And user click on from date and click on select from date
    And user click on till date and select till date
    And click on location container
    And select the location from the list
    And click on add lunch button
    Then verify the warning message


  Scenario: user leave a field blank in Apply lunch
    When user click on apply lunch
    And user click on from date and click on select from date
    And user click on till date and select till date
    And click on location container
    And click on add lunch button
    Then verify select is blank






