#Author: prajjwal.negi@geminisolutions.com
#Keyword: Knowledge Base

Feature:   MIS  Automation

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  Scenario: Add new document tags icon present and functional in view documents in knowledge base
    When navigating to view documents page
    Then add new document tags icon is present and functional

  Scenario: Add empty  document tags icon present and functional in view documents in knowledge base
    When navigating to view documents page adding empty document tag
    Then throws warning message

  Scenario Outline: Verifying monthly attendance
    When navigating to my attendance
    Then selecting "<month>" and verifying the attendance
    Examples:
      | month        |
      | January 2023 |

  Scenario: Checking right click functionality for folder
    When navigating to view documents page
    Then right click functionality is working

  Scenario: Adding an invalid document
    When navigating to view documents page and adding an invalid document type
    Then invalid document type warning should be displayed

  Scenario: Refresh button
    When navigating to view documents page and page is refreshed
    Then page is refreshed

  Scenario: Search functionality
    When navigating to view documents page and searched
    Then search is functional

  Scenario: Search functionality with absent document
    When navigating to view documents page and searched document not present
    Then search is functional and nothing is shown

  Scenario Outline: Renaming the folder
    When navigating to view documents page and renaming the "<folder>"
    Then the folder name should be renamed
    Examples:
      | folder     |
      | New Folder |

  Scenario Outline: Dropdown functionality
    When navigating to view documents page and selecting "<value>" from dropdown
    Then dropdown is functional
    Examples:
      | value |
      | 25    |

  Scenario Outline: Delete folder
    When navigating to view document and "<folderToBeDeleted>" is selected
    Then folder is deleted
    Examples:
      | folderToBeDeleted |
      | New folder 1      |

  Scenario Outline: Delete subfolder
    When navigating to view document and "<folderToClick>" is selected and "<subFolderToBeDeleted>" is selected
    Then sub folder is deleted
    Examples:
      | folderToClick | subFolderToBeDeleted |
      | abcd          | abcd1                |

  Scenario: Sorting title functionality
    When navigating to view document and title sort applied
    Then list is sorted according to title

  Scenario: Sorting date functionality
    When navigating to view document and date sort applied
    Then list is sorted according to date

  Scenario: Adding folder
    When navigating to view document and adding folder
    Then folder is added successfully

  Scenario Outline: Adding sub folder
    When navigating to view document and adding subfolder to "<folderName>"
    Then sub folder is added successfully
    Examples:
      | folderName |
      | abcd       |


  Scenario: duplicate folder check
    When navigating to view document and adding folder with duplicate name
    Then warning is given for duplicate name

  Scenario Outline: duplicate subfolder check
    When navigating to view document and adding subfolder with duplicate name to "<folderName>"
    Then warning is given for duplicate subfolder
    Examples:
      | folderName |
      | abcd       |

  Scenario: Adding an valid document
    When navigating to view documents page and adding an valid document type
    Then document is added successfully


  Scenario Outline: Dropdown functionality for view Shared document
    When navigating to view shared documents page and selecting "<value>" from dropdown
    Then dropdown is functional in view shared
    Examples:
      | value |
      | 25    |

  Scenario Outline: Search functionality in view shared document
    When navigating to view shared documents page and searching a "<documentName>"
    Then search functionlity is working
    Examples:
      | documentName                  |
      | Mastering Regular Expressions |

  Scenario Outline: Search functionality with absent document in view shared document
    When navigating to view shared documents page and searching an absent  "<documentName>"
    Then search functionlity is working by displaying no document
    Examples:
      | documentName                   |
      | Mastering Regular Expressions1 |

  Scenario: title sort Ascending
    When navigating to view shared documents page and applying ascending title sort
    Then list is sorted ascendingly

  Scenario: title sort Descending
    When navigating to view shared documents page and applying descending title sort
    Then list is sorted descendingly

  Scenario: next button
    When navigating to view shared documents page and clicking on next button
    Then next page of list is displayed

  Scenario: previous button
    When navigating to view shared documents page and clicking on previous button
    Then previous page of list is displayed


  Scenario Outline: View functionality
    When navigating to view shared documents page and viewing the "<documentName>"
    Then document is opened
    Examples:
      | documentName     |
      | Autosys tutorial |


  Scenario: Shared By sort Ascending
    When navigating to view shared documents page and applying ascending shared by sort
    Then list is sorted by shared ascendingly

  Scenario: Shared By sort Descending
    When navigating to view shared documents page and applying descending shared by sort
    Then list is sorted by shared descendingly

  Scenario: Tag sort Ascending
    When navigating to view shared documents page and applying ascending tag  sort
    Then list is sorted by tag ascendingly

  Scenario: Tag sort Descending
    When navigating to view shared documents page and applying descending tag  sort
    Then list is sorted by tag descendingly

  Scenario: Date sort Ascending
    When navigating to view shared documents page and applying ascending date sort
    Then list is sorted by date ascendingly

  Scenario: Date sort Descending
    When navigating to view shared documents page and applying descending date sort
    Then list is sorted by date descendingly