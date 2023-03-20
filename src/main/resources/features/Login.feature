#Author: charu.garg@geminisolutions.com
#Keyword: Login

Feature: Login

  Scenario:User verifies Login Page Elements Before Login
    Then Verify all the elements present on Login Page

  Scenario: User verifies elements of Login page
    Then Verify all the elements present on Login Page

  Scenario Outline: User Clicks on Sign In without entering Credentials
    When User enters "username" as "<uname>"
    When User enters "password" as "<password>"
    And Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password | errormessage                      |
      |       |          | Enter your username and password. |

  Scenario Outline: User Enters only username and Clicks on Sign In
    When User enters "username" as "<uname>"
    When User enters "password" as "<password>"
    And Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname      | password | errormessage          |
      | charu.garg |          | Password is required. |

  Scenario Outline: User Enter only password and Clicks on Sign In
    When User enters "username" as "<uname>"
    When User enters "password" as "<password>"
    And Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password         | errormessage          |
      |       | R2VtaW5pQDEyMw== | Username is required. |

  Scenario Outline: User Enters Invalid Credentials during Login
    When User enters "username" as "<uname>"
    When User enters "password" as "<password>"
    And Click on Sign In Button
    Then Verify error message "<errormessage>"
    Examples:
      | uname | password | errormessage                                                         |
      | abc   | Gemini   | The username or password you entered is not valid. Please try again. |

  Scenario Outline: User Login to the Application
    When User enters "username" as "<uname>"
    When User enters "password" as "<password>"
    And Click on Sign In Button
    Then User should be navigated to MIS homepage
    Examples:
      | uname      | password         |
      | charu.garg | R2VtaW5pQDEyMw== |

  Scenario Outline: User clicks on Forget Password link
    Given User Click on Forget Password link
    When User enters "username" as "<uname>"
    And Click on Reset Password button
    Then Verify the Success "<message>"
    Examples:
      | uname      | message                                                                  |
      | charu.garg | Password reset link sent to your official email. Kindly visit to change. |

  Scenario Outline: User Clicks on Reset link without giving username during Login
    Given User Click on Forget Password link
    When User enters "username" as "<uname>"
    And Click on Reset Password button
    Then Verify the "<message>" on the screen
    Examples:
      | uname | message              |
      |       | Enter your username. |

  Scenario Outline: User clicks on forgot password and enters invalid username during Login
    Given User Click on Forget Password link
    When User enters "username" as "<uname>"
    And Click on Reset Password button
    Then Verify the "<message>" on the screen
    Examples:
      | uname | message                                      |
      | abc   | You are not authorised to perform the action |

  Scenario Outline: User navigate back to sign In Page after Login
    When User enters "username" as "<uname>"
    Then User enters "password" as "<password>"
    And Click on Sign In Button
    Then User should be navigated to MIS homepage
    And Click on Logout button
    Then Verify User is on "Login" Page
    Examples:
      | uname      | password         |
      | charu.garg | R2VtaW5pQDEyMw== |

