#Author: shubham.kumar@geminisolutions.com
#Keyword: Leave Management

@leaveManagement
Feature: MIS - Leave Management

  Background: Login to MIS
    Given Login to MIS with Username tushar.chauhan and password R2VtaW5pQDEyMw==
    When Click on Signin button
    Then User should be navigated to MIS homepage

  # CompOff
  Scenario Outline: Leave Management : Navigate to Leave Management > Comp Off tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab      | heading                                                  |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Leave Management : Verify Date and Reason are mandatory fields for Comp Off
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "dropdown" field for "<date>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | date        | reason        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | CompOffDate | CompOffReason |

  Scenario Outline: Leave Management : Select Date from Comp Off Date dropdown
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Select compOff date <dateIndex> for "<date>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | dateIndex | date        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1         | CompOffDate |

  Scenario Outline: Leave Management : Enter Reason for Comp off Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter compOff reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | reasonMessage         | reason        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Sample Reason Message | CompOffReason |

  Scenario Outline: Leave Management : Enter Data and apply for Comp off
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Select compOff date <dateIndex> for "<date>" field
    Then Enter compOff reason "<reasonMessage>" for "<reason>" field
    Then User clicks on submit button for "<tab>"
    And Verify popup alert with message "<alertType>" and "<successMessage>"

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | dateIndex | date        | reasonMessage         | reason        | alertType | successMessage                 |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1         | CompOffDate | Sample Reason Message | CompOffReason | Success   | Request processed successfully |

  # Leave
  Scenario Outline: Leave Management : Navigate to Leave Management > Apply tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab   | heading                                                  |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Leave Management : Verify fields are Auto Populated by default on Leave tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Verify auto populated "textField" field for "<primaryContact>"
    And Verify auto populated "textField" field for "<otherContact>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | primaryContact     | otherContact          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | leaveContactNumber | leaveAltContactNumber |

  Scenario Outline: Leave Management : Verify From,Till and Reason fields are mandatory fields for Leave Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Verify auto populated "textField" field for "<primaryContact>"
    And Verify auto populated "textField" field for "<otherContact>"
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "calendar" field for "<fromDate>"
    And Verify mandatory "calendar" field for "<tillDate>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate      | tillDate      | reason      | primaryContact     | otherContact          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | leaveFromDate | leaveTillDate | leaveReason | leaveContactNumber | leaveAltContactNumber |

  Scenario Outline: Leave Management : Select From and Till Leave date from Leave Calendar
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | leaveFromDate | 04/27/2023 | leaveTillDate |

  Scenario Outline: Leave Management : Verify Total Working Days tooltip from Leave Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field
    And Click total working days tool tip
    And Verify tooltip message "<tooltipMessage>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | tooltipMessage                                             |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | leaveFromDate | 04/27/2023 | leaveTillDate | For ML total days will be considered as total working days |

  Scenario Outline: Leave Management : Choose leave for half day option from Leave tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field
    And Select half day leave for "<halfDayOptions>"
    And Verify effective total working days

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | halfDayOptions                          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | leaveFromDate | 04/27/2023 | leaveTillDate | isLeaveFirstHalfDay                     |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | leaveFromDate | 04/27/2023 | leaveTillDate | isLeaveFirstHalfDay, isLeaveLastHalfDay |

  Scenario Outline: Leave Management : Choose leave type for Leave tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field
    And Select leave type <leaveOption> for "<leaveType>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | leaveOption | leaveType |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | leaveFromDate | 04/27/2023 | leaveTillDate | 1           | leaveType |

  Scenario Outline: Leave Management : Enter reason for leave for Leave tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Enter leave reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | reasonMessage         | reason      |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Sample Reason Message | leaveReason |

  Scenario Outline: Leave Management : Choose Availability for Leave for Leave tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Select availability for "<availabilityOn>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | availabilityOn                    |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | avilableOnEmail                   |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | avilableOnEmail, avilableOnMobile |

  Scenario Outline: Leave Management : Enter required data and apply for the leave and cancel the same leave
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field
    And Select leave type <leaveOption> for "<leaveType>" field
    And Enter leave reason "<reasonMessage>" for "<reason>" field
    And Verify auto populated "textField" field for "<primaryContact>"
    And User clicks on submit button for "<tab>"
    And Verify popup alert with message "<alertType>" and "<successMessage>"
    And Click on alert OK button
    And User clicks on "<secondChildTab>" sub tab of Leave tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"
    And Cancel the leave for given period
    And User clicks on yes button to cancel the leave
    And Verify popup alert with message "Success" and "Request processed successfully"


    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | leaveOption | leaveType | reasonMessage         | reason      | primaryContact     | secondChildTab      | leavePeriod                | alertType | successMessage             |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 05/18/2023 | leaveFromDate | 05/18/2023 | leaveTillDate | 1           | leaveType | Sample Reason Message | leaveReason | leaveContactNumber | View Request Status | 18-May-2023 to 18-May-2023 | Success   | Leave applied successfully |

    # LWP Change Request
  Scenario Outline: Leave Management : Navigate to Leave Management > LWP Change Request tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab                | heading                                                  |
      | Leave Management | Apply    | LWP Change Request | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Leave Management : Verify LWP Date, Type of leave and Reason fields are mandatory
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "dropdown" field for "<date>"
    And Verify mandatory "dropdown" field for "<leaveType>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab                | heading                                                  | date   | leaveType      | reason           | primaryContact     | otherContact          |
      | Leave Management | Apply    | LWP Change Request | Apply Leave / WFH / Comp Off / Out Duty / Change Request | fromDt | legitimateType | legitimateReason | leaveContactNumber | leaveAltContactNumber |

#     Out Duty/Tour
  Scenario Outline: Leave Management : Navigate to Leave Management > Out of Duty/Tour tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab           | heading                                                  |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Leave Management : Verify Out Duty Date, Type of leave and Reason fields are mandatory
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then User clicks on submit button for "<tab>"
    And Verify mandatory "outingCalendar" field for "<fromDate>"
    And Verify mandatory "outingCalendar" field for "<toDate>"
    And Verify mandatory "dropdown" field for "<type>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | fromDate       | toDate         | type       | reason       |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | outingFromDate | outingTillDate | outingType | outingReason |

  Scenario Outline: Leave Management : Select Out Duty From and Till Leave date from Calendar
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing "<fromDate>" for "<fromDateField>" field
    Then Enter outing "<toDate>" for "<toDateField>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | fromDate   | toDate     | fromDateField  | toDateField    |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/10/2023 | 04/10/2023 | outingFromDate | outingTillDate |

  Scenario Outline: Leave Management : Select type for Out Duty Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Select outing type "<outingOption>" for "<outingType>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | outingOption          | outingType |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Tour (Overseas Visit) | outingType |

  Scenario Outline: Leave Management : Select Reason for Out Duty Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | reasonMessage | reason       |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Outing Reason | outingReason |

  Scenario Outline: Leave Management : Enter Primary Contact Number for Out Duty Tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing contact no "<primaryContactNo>" for "<primaryContact>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | primaryContactNo | primaryContact      |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 9878787678       | outingContactNumber |

  Scenario Outline: Leave Management : Enter Data and Click on Submit for Out of Duty tab
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing "<fromDate>" for "<fromDateField>" field
    Then Enter outing "<toDate>" for "<toDateField>" field
    Then Select outing type "<outingOption>" for "<outingType>" field
    And Enter outing reason "<reasonMessage>" for "<reason>" field
    And Enter outing contact no "<primaryContactNo>" for "<primaryContact>" field
    And Enter outing contact no "<otherContactNo>" for "<otherContact>" field
    Then User clicks on submit button for "<tab>"
    And Verify popup alert with message "<alertType>" and "<successMessage>"

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | fromDate   | fromDateField  | toDate     | toDateField    | outingOption          | outingType | reasonMessage | reason       | primaryContactNo | primaryContact      | otherContactNo | otherContact           | alertType | successMessage                                       |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 04/26/2023 | outingFromDate | 04/26/2023 | outingTillDate | Tour (Overseas Visit) | outingType | Outing Reason | outingReason | 9878787678       | outingContactNumber | 9878787678     | outingAltContactNumber | Success   | Out Duty/Tour request has been applied successfully. |

  Scenario Outline: Leave Management : Navigate to Leave Management > WFH tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab            | heading                                                  |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Leave Management : Verify field is Auto Populated by default in WFH tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Verify auto populated "textField" field for "<mobileNo>"

    Examples:
      | parentTab        | childTab | tab            | heading                                                  | mobileNo |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request | mobileNo |

  Scenario Outline: Leave Management : Verify WFH Date and WFH Reason are mandatory fields
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And User clicks on submit button for "<tab>"
    And Verify mandatory "dropdown" field for "<date>"
    And Verify mandatory "textArea" field for "<reason>"

    Examples:
      | parentTab        | childTab | tab            | heading                                                  | date             | reason    |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request | WorkFromHomeDate | WFHReason |

  Scenario Outline: Leave Management : Select Date from WFH Date dropdown
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Select WFH date <dateOption> for "<date>" field

    Examples:
      | parentTab        | childTab | tab            | heading                                                  | dateOption | date             |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1          | WorkFromHomeDate |

  Scenario Outline: Leave Management : Enter reason for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Enter outing reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab            | heading                                                  | reasonMessage      | reason    |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request | WFH Reason Message | WFHReason |

  Scenario Outline: Leave Management : Enter required data and apply for WFH
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Select WFH date <dateOption> for "<date>" field
    And Enter outing reason "<reasonMessage>" for "<reason>" field
    And User clicks on submit button for "<tab>"
    And Verify popup alert with message "<alertType>" and "<successMessage>"

    Examples:
      | parentTab        | childTab | tab            | heading                                                  | dateOption | date             | reasonMessage      | reason    | alertType | successMessage                 |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1          | WorkFromHomeDate | WFH Reason Message | WFHReason | Success   | Request processed successfully |

  Scenario Outline: Leave Management : Navigate to Leave Management > View Request Status tab > Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Change Request |

  Scenario Outline: Leave Management : Verify Date Range field is present for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Change Request |

  Scenario Outline: Leave Management : Enter Invalid Date Range for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Invalid" date "<date>" in Date range field
    And Verify "Invalid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab            | date         | message          |
      | Leave Management | View Request Status | Change Request | 01 Apr 20000 | No results found |

  Scenario Outline: Leave Management : Enter Valid Date Range for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Valid" date "<date>" in Date range field
    And Verify "Valid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab            | date                      | message                   |
      | Leave Management | View Request Status | Change Request | 01 Apr 2022 - 31 Mar 2023 | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Leave Management : Click on Export Options Option for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    Examples:
      | parentTab        | childTab            | tab            | exportList              |
      | Leave Management | View Request Status | Change Request | Copy, Excel, PDF, Print |

  Scenario Outline: Leave Management : Click on Print Option for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Print page appears
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton |
      | Leave Management | View Request Status | Change Request | Copy, Excel, PDF, Print | Print        |

  Scenario Outline: Leave Management : Click on Copy Option for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Copy to clipboard message "<message>"
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | message           |
      | Leave Management | View Request Status | Change Request | Copy, Excel, PDF, Print | Copy         | Copy to clipboard |

  Scenario Outline: Leave Management : Click on Excel Option for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | fileName                |
      | Leave Management | View Request Status | Change Request | Copy, Excel, PDF, Print | Excel        | Leave History List.xlsx |

  Scenario Outline: Leave Management : Verify PDF option for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | fileName               |
      | Leave Management | View Request Status | Change Request | Copy, Excel, PDF, Print | PDF          | Leave History List.pdf |

  Scenario Outline: Leave Management : Navigate to Leave Management > View Request Status tab > Comp Off
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed

    Examples:
      | parentTab        | childTab            | tab      |
      | Leave Management | View Request Status | Comp Off |

  Scenario Outline: Leave Management : Verify Date Range field is present for Change Request
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present

    Examples:
      | parentTab        | childTab            | tab      |
      | Leave Management | View Request Status | Comp Off |

  Scenario Outline: Leave Management : Enter Invalid Date Range for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Invalid" date "<date>" in Date range field
    And Verify "Invalid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab      | date         | message          |
      | Leave Management | View Request Status | Comp Off | 01 Apr 20000 | No results found |

  Scenario Outline: Leave Management : Enter Valid Date Range for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Valid" date "<date>" in Date range field
    And Verify "Valid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab      | date                      | message                   |
      | Leave Management | View Request Status | Comp Off | 01 Apr 2022 - 31 Mar 2023 | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Leave Management : Click on Export Options Option for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    Examples:
      | parentTab        | childTab            | tab      | exportList              |
      | Leave Management | View Request Status | Comp Off | Copy, Excel, PDF, Print |

  Scenario Outline: Leave Management : Click on Print Option for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Print page appears
    Examples:
      | parentTab        | childTab            | tab      | exportList              | exportButton |
      | Leave Management | View Request Status | Comp Off | Copy, Excel, PDF, Print | Print        |

  Scenario Outline: Leave Management : Click on Excel Option for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab      | exportList              | exportButton | fileName                  |
      | Leave Management | View Request Status | Comp Off | Copy, Excel, PDF, Print | Excel        | CompOff History List.xlsx |

  Scenario Outline: Leave Management : Verify PDF option for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab      | exportList              | exportButton | fileName                 |
      | Leave Management | View Request Status | Comp Off | Copy, Excel, PDF, Print | PDF          | CompOff History List.pdf |

  Scenario Outline: Leave Management : Enter Comp Off Period Name in Search Box for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<compOffPeriod>" period in search box for "<tab>"
    And Verify "<compOffPeriod>" period as search result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab      | compOffPeriod |
      | Leave Management | View Request Status | Comp Off | 26-Feb-2023   |

  Scenario Outline: Leave Management : Sort columns for Comp Off Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Sort column "<columnName>" for "<tab>"
    And Verify sorted column "<columnName>" result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab      | columnName |
      | Leave Management | View Request Status | Comp Off | Applied On |

  Scenario Outline: Leave Management : Navigate to Leave Management > View Request Status tab > Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed

    Examples:
      | parentTab        | childTab            | tab   |
      | Leave Management | View Request Status | Leave |

  Scenario Outline: Leave Management : Verify Date Range field is present for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present

    Examples:
      | parentTab        | childTab            | tab   |
      | Leave Management | View Request Status | Leave |

  Scenario Outline: Leave Management : Enter Invalid Date Range for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Invalid" date "<date>" in Date range field
    And Verify "Invalid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab   | date         | message          |
      | Leave Management | View Request Status | Leave | 01 Apr 20000 | No results found |

  Scenario Outline: Leave Management : Verify Export Options for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    Examples:
      | parentTab        | childTab            | tab   | exportList              |
      | Leave Management | View Request Status | Leave | Copy, Excel, PDF, Print |

  Scenario Outline: Leave Management : Click on Print Option for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Print page appears
    Examples:
      | parentTab        | childTab            | tab   | exportList              | exportButton |
      | Leave Management | View Request Status | Leave | Copy, Excel, PDF, Print | Print        |

  Scenario Outline: Leave Management : Click on Excel Option for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab   | exportList              | exportButton | fileName                |
      | Leave Management | View Request Status | Leave | Copy, Excel, PDF, Print | Excel        | Leave History List.xlsx |

  Scenario Outline: Leave Management : Click on Copy Option for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Copy to clipboard message "<message>"
    Examples:
      | parentTab        | childTab            | tab   | exportList              | exportButton | message           |
      | Leave Management | View Request Status | Leave | Copy, Excel, PDF, Print | Copy         | Copy to clipboard |

  Scenario Outline: Leave Management : Verify PDF option for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab   | exportList              | exportButton | fileName               |
      | Leave Management | View Request Status | Leave | Copy, Excel, PDF, Print | PDF          | Leave History List.pdf |

  Scenario Outline: Leave Management : Verify Number of Entries displayed for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Verify number of rows displayed for "<tab>" tab
    Examples:
      | parentTab        | childTab            | tab   |
      | Leave Management | View Request Status | Leave |

  Scenario Outline: Leave Management : Enter Leave Period Name in Search Box for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab   | leavePeriod                |
      | Leave Management | View Request Status | Leave | 28-Dec-2022 to 02-Jan-2023 |

  Scenario Outline: Leave Management : Sort columns for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Sort column "<columnName>" for "<tab>"
    And Verify sorted column "<columnName>" result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab   | columnName |
      | Leave Management | View Request Status | Leave | Period     |

  Scenario Outline: Leave Management : Page Next for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on "Next" button for "<tab>"
    And Verify table navigate to "Next" page for "<tab>"

    Examples:
      | parentTab        | childTab            | tab   |
      | Leave Management | View Request Status | Leave |


  Scenario Outline: Leave Management : Page Previous for Leave Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on "Next" button for "<tab>"
    And Verify table navigate to "Next" page for "<tab>"
    And Click on "Previous" button for "<tab>"
    And Verify table navigate to "Previous" page for "<tab>"

    Examples:
      | parentTab        | childTab            | tab   |
      | Leave Management | View Request Status | Leave |

  Scenario Outline: Leave Management : Navigate to Leave Management > View Request Status tab > Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed

    Examples:
      | parentTab        | childTab            | tab           |
      | Leave Management | View Request Status | Out Duty/Tour |

  Scenario Outline: Leave Management : Verify Date Range field is present for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present

    Examples:
      | parentTab        | childTab            | tab           |
      | Leave Management | View Request Status | Out Duty/Tour |

  Scenario Outline: Leave Management : Enter Invalid Date Range for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Invalid" date "<date>" in Date range field
    And Verify "Invalid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab           | date         | message          |
      | Leave Management | View Request Status | Out Duty/Tour | 01 Apr 20000 | No results found |

  Scenario Outline: Leave Management : Enter Valid Date Range for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Valid" date "<date>" in Date range field
    And Verify "Valid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab           | date                      | message                   |
      | Leave Management | View Request Status | Out Duty/Tour | 01 Apr 2022 - 31 Mar 2023 | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Leave Management : Click on Export Options Option for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    Examples:
      | parentTab        | childTab            | tab           | exportList              |
      | Leave Management | View Request Status | Out Duty/Tour | Copy, Excel, PDF, Print |

  Scenario Outline: Leave Management : Click on Print Option for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Print page appears
    Examples:
      | parentTab        | childTab            | tab           | exportList              | exportButton |
      | Leave Management | View Request Status | Out Duty/Tour | Copy, Excel, PDF, Print | Print        |

  Scenario Outline: Leave Management : Click on Excel Option for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab           | exportList              | exportButton | fileName          |
      | Leave Management | View Request Status | Out Duty/Tour | Copy, Excel, PDF, Print | Excel        | Gemini - MIS.xlsx |

  Scenario Outline: Leave Management : Click on Copy Option for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Copy to clipboard message "<message>"
    Examples:
      | parentTab        | childTab            | tab           | exportList              | exportButton | message           |
      | Leave Management | View Request Status | Out Duty/Tour | Copy, Excel, PDF, Print | Copy         | Copy to clipboard |

  Scenario Outline: Leave Management : Verify PDF option for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab           | exportList              | exportButton | fileName         |
      | Leave Management | View Request Status | Out Duty/Tour | Copy, Excel, PDF, Print | PDF          | Gemini - MIS.pdf |

  Scenario Outline: Leave Management : Sort columns for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Sort column "<columnName>" for "<tab>"
    And Verify sorted column "<columnName>" result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab           | columnName |
      | Leave Management | View Request Status | Out Duty/Tour | Duty Type  |

  Scenario Outline: Leave Management : Enter Out Duty/Tour Period in Search Box for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab           | leavePeriod                |
      | Leave Management | View Request Status | Out Duty/Tour | 13 Mar 2023 To 14 Mar 2023 |

  Scenario Outline: Leave Management : Verify Data is present for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab           | leavePeriod                |
      | Leave Management | View Request Status | Out Duty/Tour | 13 Mar 2023 To 14 Mar 2023 |

  Scenario Outline: Leave Management : Click on View button for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"
    And Click on view button for Out Duty Tour searched result
    And Verify the detailed popup "<header>" for Out Duty Tour

    Examples:
      | parentTab        | childTab            | tab           | leavePeriod                | header                       |
      | Leave Management | View Request Status | Out Duty/Tour | 13 Mar 2023 To 14 Mar 2023 | Out Duty/Tour Request Detail |

  Scenario Outline: Leave Management : Verify Date in View Window for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"
    And Click on view button for Out Duty Tour searched result
    And Verify the detailed popup "<header>" for Out Duty Tour
    And Verify Outing Date "<leavePeriod>" for Out Duty Tour Details Popup

    Examples:
      | parentTab        | childTab            | tab           | leavePeriod                | header                       |
      | Leave Management | View Request Status | Out Duty/Tour | 13 Mar 2023 To 14 Mar 2023 | Out Duty/Tour Request Detail |

  Scenario Outline: Leave Management : Search in View Window for Out Duty/Tour
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<leavePeriod>" period in search box for "<tab>"
    And Verify "<leavePeriod>" period as search result for "<tab>"
    And Click on view button for Out Duty Tour searched result
    And Verify the detailed popup "<header>" for Out Duty Tour
    And User enters "<outingDate>" period in search box for out duty details
    And Verify "<outingDate>" period as search result for out duty details

    Examples:
      | parentTab        | childTab            | tab           | leavePeriod                | header                       | outingDate  |
      | Leave Management | View Request Status | Out Duty/Tour | 13 Mar 2023 To 14 Mar 2023 | Out Duty/Tour Request Detail | 14-Mar-2023 |


  Scenario Outline: Leave Management : Navigate to Leave Management > View Request Status tab > Work From Home
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Work From Home |

  Scenario Outline: Leave Management : Verify Date Range field is present for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Work From Home |

  Scenario Outline: Leave Management : Enter Invalid Date Range for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Invalid" date "<date>" in Date range field
    And Verify "Invalid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab            | date         | message          |
      | Leave Management | View Request Status | Work From Home | 01 Apr 20000 | No results found |

  Scenario Outline: Leave Management : Enter Valid Date Range for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status "Date Range" dropdown
    And Enter "Valid" date "<date>" in Date range field
    And Verify "Valid" message "<message>" displays
    Examples:
      | parentTab        | childTab            | tab            | date                      | message                   |
      | Leave Management | View Request Status | Work From Home | 01 Apr 2022 - 31 Mar 2023 | 01 Apr 2022 - 31 Mar 2023 |

  Scenario Outline: Leave Management : Click on Export Options Option for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    Examples:
      | parentTab        | childTab            | tab            | exportList              |
      | Leave Management | View Request Status | Work From Home | Copy, Excel, PDF, Print |

  Scenario Outline: Leave Management : Click on Print Option for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Print page appears
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton |
      | Leave Management | View Request Status | Work From Home | Copy, Excel, PDF, Print | Print        |

  Scenario Outline: Leave Management : Click on Excel Option for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | fileName              |
      | Leave Management | View Request Status | Work From Home | Copy, Excel, PDF, Print | Excel        | WFH History List.xlsx |

  Scenario Outline: Leave Management : Click on Copy Option for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify Copy to clipboard message "<message>"
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | message           |
      | Leave Management | View Request Status | Work From Home | Copy, Excel, PDF, Print | Copy         | Copy to clipboard |

  Scenario Outline: Leave Management : Verify PDF option for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on View Request Status export button for "<tab>"
    And Verify available export options "<exportList>"
    And Click on View Request Status "<exportButton>" button
    And Verify file "<fileName>" is downloaded in MIS
    Examples:
      | parentTab        | childTab            | tab            | exportList              | exportButton | fileName             |
      | Leave Management | View Request Status | Work From Home | Copy, Excel, PDF, Print | PDF          | WFH History List.pdf |

  Scenario Outline: Leave Management : Verify Number of Entries displayed for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Verify number of rows displayed for "<tab>" tab
    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Work From Home |

  Scenario Outline: Leave Management : Enter WFH Period Name in Search Box for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And User enters "<period>" period in search box for "<tab>"
    And Verify "<period>" period as search result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab            | period      |
      | Leave Management | View Request Status | Work From Home | 01-Feb-2023 |

  Scenario Outline: Leave Management : Sort columns for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Sort column "<columnName>" for "<tab>"
    And Verify sorted column "<columnName>" result for "<tab>"

    Examples:
      | parentTab        | childTab            | tab            | columnName |
      | Leave Management | View Request Status | Work From Home | Reason     |

  Scenario Outline: Leave Management : Page Next for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on "Next" button for "<tab>"
    And Verify table navigate to "Next" page for "<tab>"

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Work From Home |


  Scenario Outline: Leave Management : Page Previous for WFH Tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And User clicks on "<tab>" Tab
    And Verify "<tab>" headers are displayed
    And Verify Date Range field is present
    And Click on "Next" button for "<tab>"
    And Verify table navigate to "Next" page for "<tab>"
    And Click on "Previous" button for "<tab>"
    And Verify table navigate to "Previous" page for "<tab>"

    Examples:
      | parentTab        | childTab            | tab            |
      | Leave Management | View Request Status | Work From Home |