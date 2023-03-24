#Author: shruti.singh@geminisolutions.com
#Keyword: Forms

Feature: Forms Automation

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario Outline: View Forms: Open view forms page

    When User clicks on tab "<parentTab>" and "<childTab>"
    And User verifies element "<firstElement>"
    Then User verifies element "<secondElement>"
    Examples:
      | parentTab | childTab  | firstElement | secondElement |
      | Forms     | View Form | View Forms   | Form Name     |

  Scenario Outline: View Forms: User checks the  presence of previous and next Button
    When User clicks on tab "<parent Tab>" and "<child Tab>"
    And User verifies the presence of "<buttonOne>" Button
    Then User verifies the presence of "<buttonTwo>" Button
    Examples:
      | parent Tab | child Tab | buttonOne | buttonTwo |
      | Forms      | View Form | Previous  | Next      |

  Scenario Outline: View Forms: User selects a department
    When User clicks on tab "<parentTab>" and "<childTab>"
    And User clicks on department
    Then User clicks on "<desiredDepartment>"
    Examples:
      | parentTab | childTab  | desiredDepartment |
      | Forms     | View Form | Accounts          |

  Scenario Outline: View Forms: User selects the entries
    When User clicks on tab "<parentTab>" and "<childTab>"
    Then User selects the entries as "<element>"
    Examples:
      | parentTab | childTab  | element |
      | Forms     | View Form | 25      |

  Scenario Outline: View Forms: User enters valid value in search field
    When User clicks on tab "<parentTab>" and "<childTab>"
    And User search field and enters value "<value>"
    Examples:
      | parentTab | childTab  | value    |
      | Forms     | View Form | Accounts |

  Scenario Outline: View Forms: User enters invalid value in search field
    When User clicks on tab "<parentTab>" and "<childTab>"
    And User search field and enters invalid value "<value>"
    Then User verifies the invalid value "<element>"
    Examples:
      | parentTab | childTab  | value | element                   |
      | Forms     | View Form | QA    | No matching records found |

  Scenario Outline: View Forms: User clicks on eye button to view policy
    When  User clicks on tab "<parentTab>" and "<childTab>"
    And  User clicks on eye button
    Then User views policy
    Examples:
      | parentTab | childTab  |
      | Forms     | View Form |

  Scenario Outline: View Forms: User downloads document
    When  User clicks on tab "<parentTab>" and "<childTab>"
    Then User click on download image
    Examples:
      | parentTab | childTab  |
      | Forms     | View Form |


  Scenario Outline: My Forms: User opens my forms page
    When  User clicks on the "<parentTab>" and "<childTab>"
    Then Verify the heading on the landing page
    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline: My Forms: User uploads correct File
    When  User clicks on the "<parentTab>" and "<childTab>"
    And User clicks on upload button
    And User uploads the desired document "<formType>" from "<path>"
    Then User clicks on save button
    Examples:
      | parentTab | childTab | formType                | path                                                |
      | Forms     | My Form  | Loyalty Redemption Form | \\src\\main\\resources\\Loyalty Redemption Form.pdf |

  Scenario Outline: My Forms: User uploads incorrect File
    When  User clicks on the "<parentTab>" and "<childTab>"
    And User clicks on upload button
    And User uploads the undesired document "<formType>" from "<path>"
    And  Verify the warning "<warningMsg>"
    Then User clicks on ok button
    Examples:
      | parentTab | childTab | formType                | warningMsg                                                      | path                                |
      | Forms     | My Form  | Loyalty Redemption Form | Invalid file selected. Supported extensions are .xlsx,.xls,.pdf | \\src\\main\\resources\\17 may.docx |

  Scenario Outline: My Forms: User selects number of entries
    When  User clicks on the "<parentTab>" and "<childTab>"
    Then User selects the entries as "<element>"

    Examples:
      | parentTab | childTab | element |
      | Forms     | My Form  | 25      |

  Scenario Outline: My Forms: User enters valid value in my forms search field
    When  User clicks on the "<parentTab>" and "<childTab>"
    Then User enters valid value in my forms search field as "<element>"

    Examples:
      | parentTab | childTab | element                       |
      | Forms     | My Form  | Loyal Loyalty Redemption Form |

  Scenario Outline: My Forms: User enters invalid value in My forms search field
    When  User clicks on the "<parentTab>" and "<childTab>"
    And User enters invalid value in My forms search field as "<value>"

    Examples:
      | parentTab | childTab | value |
      | Forms     | My Form  | QA    |

  Scenario Outline: My Forms: User downloads from my forms page
    When  User clicks on the "<parentTab>" and "<childTab>"
    Then User hovers and clicks on download button

    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline: My Forms: User hover over and clicks on deactivate button
    When  User clicks on the "<parentTab>" and "<childTab>"
    And User hovers and clicks on deactivate button
    Then User clicks on yes button

    Examples:
      | parentTab | childTab |
      | Forms     | My Form  |

  Scenario Outline: My Forms: User uploads the file with same name
    When  User clicks on the "<parentTab>" and "<childTab>"
    And User clicks on upload button
    And User uploads the desired document "<formType>" from "<path>"
    And  User clicks on save button
    And User validates the error message as "<element>"
    Then User clicks on ok button

    Examples:
      | parentTab | childTab | formType                | element                            | path                                                |
      | Forms     | My Form  | Loyalty Redemption Form | File with same name already exists | \\src\\main\\resources\\Loyalty Redemption Form.pdf |


