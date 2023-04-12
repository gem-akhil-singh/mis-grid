@TestGrid
Feature: Test Window Handle Feature
  Background: User Login into the Gembook Application
    When User Navigates to "https://gembook.geminisolutions.com/#/"
    And User clicks on signIn Button
    Then User enters the "username"
    Then User enters the "password"
    And User logins into the application
    Then Verify user is logged into the application or not
    When User navigates to tab "News Feeds"

  Scenario Outline: Gembook_OtherPortals_NavigationToNewPageOnClicking<desiredPage>
    Given Check if Other Portals is present in side bar
    When Check if all sub items are present
    Then User clicks on the "<desiredPage>" menu item
    Then Verify if user is navigated to "<desiredPage>" having "<URL>" with "<title>"
    Examples:
      | desiredPage  | URL                                     | title               |
      | Jenkins      | https://jenkins-np.geminisolutions.com/ | Dashboard [Jenkins] |
      | Service Desk | https://helpdesk.geminisolutions.com/   | Helpdesk            |