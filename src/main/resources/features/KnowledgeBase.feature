#Author: prajjwal.negi@geminisolutions.com
#Keyword: Knowledge Base

Feature:   Knowledge Base Functionality Automation

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Knowledge Base: Add new document tags icon present and functional in view documents in knowledge base section
    When Navigating to view documents page
    Then Verifying add new document tags icon is present and functional

  Scenario: Knowledge Base: Add empty  document tags icon present and functional in view documents in knowledge base
    When Navigating to view documents page adding empty document tag
    Then Verifying it throws warning message

  Scenario Outline: Knowledge Base: Verifying monthly attendance
    When Navigating to my attendance
    Then Verifying it is selecting "<month>" and verifying the attendance
    Examples:
      | month        |
      | January 2023 |

  Scenario: Knowledge Base: Checking right click functionality for folder in view document
    When Navigating to view documents page
    Then Verifying right click functionality is working

  Scenario: Knowledge Base: Adding an invalid document to a folder in view document
    When Navigating to view documents page and adding an invalid document type
    Then Verifying invalid document type warning should be displayed

  Scenario: Knowledge Base: Refresh the page for view document
    When Navigating to view documents page and page is refreshed
    Then Verifying page is refreshed

  Scenario: Knowledge Base: Search functionality in view document page
    When Navigating to view documents page and searched
    Then Verify search is functional

  Scenario Outline: Knowledge Base: Search functionality with absent document in view document
    When Navigating to view documents page and searched document not present
    Then Verify search with "<value>" is functional and nothing is shown with "<message>"
    Examples:
      | value | message |
      | xyz2 | No matching records found |

  Scenario Outline: Knowledge Base: Renaming the folder in view document
    When Navigating to view documents page and renaming the "<folder>"
    Then Verify folder name should be renamed
    Examples:
      | folder     |
      | New Folder |

  Scenario Outline: Knowledge Base: Dropdown functionality in view document
    When Navigating to view documents page and selecting from dropdown
    Then Verify dropdown is functional with "<value>"
    Examples:
      | value |
      | 25    |

  Scenario Outline: Knowledge Base: Delete folder in view document
    When Navigating to view document and "<folderToBeDeleted>" is selected
    Then Verify folder is deleted
    Examples:
      | folderToBeDeleted |
      | New folder 1      |

  Scenario Outline: Knowledge Base: Delete subfolder within a folder in view document
    When Navigating to view document and "<folderToClick>" is selected and "<subFolderToBeDeleted>" is selected
    Then Verify sub folder is deleted
    Examples:
      | folderToClick | subFolderToBeDeleted |
      | abcd          | abcd1                |

  Scenario: Knowledge Base: Sorting title functionality within folder in view document
    When Navigating to view document and title sort applied
    Then Verify list is sorted according to title

  Scenario: Knowledge Base: Sorting date functionality within folder in view document
    When Navigating to view document and date sort applied
    Then Verify list is sorted according to date

  Scenario: Knowledge Base: Adding folder in view document
    When Navigating to view document and adding folder
    Then Verify folder is added successfully

  Scenario Outline: Knowledge Base: Adding sub folder within a folder in view document
    When Navigating to view document and adding subfolder to "<folderName>"
    Then Verify sub folder is added successfully
    Examples:
      | folderName |
      | abcd       |


  Scenario: Knowledge Base: Duplicate folder check in view document
    When Navigating to view document and adding folder with duplicate name
    Then Verify warning is given for duplicate name

  Scenario Outline: Knowledge Base: Duplicate subfolder check within a folder in view document
    When Navigating to view document and adding subfolder with duplicate name to "<folderName>"
    Then Verify warning is given for duplicate subfolder
    Examples:
      | folderName |
      | abcd       |

  Scenario: Knowledge Base: Adding an valid document in a folder in view document
    When Navigating to view documents page and adding an valid document type
    Then Verify document is added successfully


  Scenario Outline: Knowledge Base: Dropdown functionality for view Shared document
    When Navigating to view shared documents page and selecting from dropdown
    Then Verify dropdown is functional in view shared with "<value>"
    Examples:
      | value |
      | 25    |

  Scenario Outline: Knowledge Base: Search functionality in view shared document
    When Navigating to view shared documents page and searching a document
    Then Verify search functionlity is working with "<documentName>"
    Examples:
      | documentName                  |
      | Mastering Regular Expressions |

  Scenario Outline: Knowledge Base: Search functionality with absent document in view shared document
    When Navigating to view shared documents page and searching an absent  "<documentName>"
    Then Verify search functionlity is working by displaying no document
    Examples:
      | documentName                   |
      | Mastering Regular Expressions1 |

  Scenario Outline: Knowledge Base: Title sort Ascending for view shared document
    When Navigating to view shared documents page and applying ascending title sort
    Then Verify list is sorted ascendingly with "<name>"
    Examples:
      | name |
      | An introduction to Python for absolute beginners |


  Scenario Outline: Knowledge Base: Title sort Descending for view shared document
    When Navigating to view shared documents page and applying descending title sort
    Then Verify list is sorted descendingly with "<name>"
    Examples:
      | name |
      | Unix Tutorials |

  Scenario Outline: Knowledge Base: Next button for documents in view shared document
    When Navigating to view shared documents page and clicking on next button
    Then Verify next page of list is displayed with "<number>"
    Examples:
      | number |
      | 11 |

  Scenario Outline: Knowledge Base: Previous button for document in view shared document
    When Navigating to view shared documents page and clicking on previous button
    Then Verify previous page of list is displayed with "<number>" after diplaying the next list with "<number 2>"
    Examples:
      | number | number 2 |
      | 1 | 11 |


  Scenario Outline: Knowledge Base: View functionality for document in view shared document
    When Navigating to view shared documents page and viewing the "<documentName>"
    Then Verify document is opened
    Examples:
      | documentName     |
      | Autosys tutorial |


  Scenario Outline: Knowledge Base: Shared By sort Ascending for documents in view shared document
    When Navigating to view shared documents page and applying ascending shared by sort
    Then Verifying list is sorted by shared ascendingly with "<sharedName>"
    Examples:
      | sharedName |
      | Amrita Tiwari |


  Scenario Outline: Knowledge Base: Shared By sort Descending for documents in view shared document
    When Navigating to view shared documents page and applying descending shared by sort
    Then Verifying list is sorted by shared descendingly with "<sharedName>"
    Examples:
      | sharedName |
      | Rahul Paul |

  Scenario Outline: Knowledge Base: Tag sort Ascending for documents in view shared document
    When Navigating to view shared documents page and applying ascending tag  sort
    Then Verifying list is sorted by tag ascendingly with "<tag>"
    Examples:
      | tag |
      | Autosys |

  Scenario Outline: Knowledge Base: Tag sort Descending for documents in view shared document
    When Navigating to view shared documents page and applying descending tag  sort
    Then Verifying list is sorted by tag descendingly with "<tag>"
    Examples:
      | tag |
      | Unix Tutorial, finance |

  Scenario Outline: Knowledge Base: Date sort Ascending for documents in view shared document
    When Navigating to view shared documents page and applying ascending date sort
    Then Verifying list is sorted by date ascendingly with "<date>"
    Examples:
      | date |
      | 31-Mar-2015 |

  Scenario Outline: Knowledge Base: Date sort Descending for document in view shared document
    When Navigating to view shared documents page and applying descending date sort
    Then Verifying list is sorted by date descendingly with "<date>"
    Examples:
      | date |
      | 12-Sep-2018 |