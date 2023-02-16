Feature: Policy

  Background: Login
    When User enters "username" as "charu.garg"
    Then User enters "password" as "R2VtaW5pQDEyMw=="
    Then Click on Sign In Button
    Then Verify User is on "MIS Home" Page

  Scenario: Navigate to Policy > View Policies
    When User clicks on Policy
    And Click on View Policies

  Scenario Outline:Verify Title of Policy Tab
    When User clicks on Policy
    And Click on View Policies
    Then Check the "<title>" of policy tab
    Examples:
      | title         |
      | View Policies |

  Scenario: Verify Data is present in Policies tab
    When User clicks on Policy
    And Click on View Policies
    Then Verify Data is present in Policies tab