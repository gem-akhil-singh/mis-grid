Feature: MIS - Leave Management

  Background: Login into MIS
    Given User is logged into MIS using username and password
      | username      | password         |
      | shubham.kumar | R2VtaW5pQDEyMw== |
    When User is on MIS Home Page

  # CompOff
  Scenario Outline: Navigate to Leave Management > Comp Off tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab      | heading                                                  |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify Date and Reason are mandatory fields for Comp Off
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

  Scenario Outline: Select Date from Comp Off Date dropdown
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Select compOff date <dateIndex> for "<date>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | dateIndex | date        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 1         | CompOffDate |

  Scenario Outline: Enter Reason for Comp off
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter compOff reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab      | heading                                                  | reasonMessage         | reason        |
      | Leave Management | Apply    | Comp Off | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Sample Reason Message | CompOffReason |

  Scenario Outline: Enter Data and submit Comp off
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
  Scenario Outline: Navigate to Leave Management > Apply tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab   | heading                                                  |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify fields are Auto Populated by default on Leave tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Verify auto populated "textField" field for "<primaryContact>"
    And Verify auto populated "textField" field for "<otherContact>"

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | primaryContact     | otherContact          |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | leaveContactNumber | leaveAltContactNumber |

  Scenario Outline: Verify From,Till and Reason fields are mandatory fields for Leave Tab
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

  Scenario Outline: Select From and Till Leave date from Leave Calendar
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate |

  Scenario Outline: Verify Total Working Days tooltip from Leave Tab
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
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | For ML total days will be considered as total working days |

  Scenario Outline: Choose leave for half day option from Leave tab
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
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | isLeaveFirstHalfDay                     |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | isLeaveFirstHalfDay, isLeaveLastHalfDay |

  Scenario Outline: Choose leave type
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter leave "<fromDate>" for "<fromDateField>" field
    Then Enter leave "<toDate>" for "<toDateField>" field
    And Select leave type <leaveOption> for "<leaveType>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | leaveOption | leaveType |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | 1           | leaveType |

  Scenario Outline: Enter reason for leave
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Enter leave reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | reasonMessage         | reason      |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Sample Reason Message | leaveReason |

  Scenario Outline: Choose Availability for Leave
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    And Select availability for "<availabilityOn>" field

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | availabilityOn                    |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | avilableOnEmail                   |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | avilableOnEmail, avilableOnMobile |

  Scenario Outline: Enter required data and click on Submit leave
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

    Examples:
      | parentTab        | childTab | tab   | heading                                                  | fromDate   | fromDateField | toDate     | toDateField   | leaveOption | leaveType | reasonMessage         | reason      | primaryContact     |
      | Leave Management | Apply    | Leave | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/15/2023 | leaveFromDate | 03/16/2023 | leaveTillDate | 1           | leaveType | Sample Reason Message | leaveReason | leaveContactNumber |

    # LWP Change Request
  Scenario Outline: Navigate to Leave Management > LWP Change Request tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab                | heading                                                  |
      | Leave Management | Apply    | LWP Change Request | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify LWP Date, Type of leave and Reason fields are mandatory
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
  Scenario Outline: Navigate to Leave Management > Out of Duty/Tour tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab           | heading                                                  |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request |

  Scenario Outline: Verify Out Duty Date, Type of leave and Reason fields are mandatory
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

  Scenario Outline: Select Out Duty From and Till Leave date from Calendar
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing "<fromDate>" for "<fromDateField>" field
    Then Enter outing "<toDate>" for "<toDateField>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | fromDate   | toDate     | fromDateField  | toDateField    |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/10/2023 | 04/10/2023 | outingFromDate | outingTillDate |

  Scenario Outline: Select type for Out Duty
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Select outing type "<outingOption>" for "<outingType>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | outingOption          | outingType |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Tour (Overseas Visit) | outingType |

  Scenario Outline: Select Reason for Out Duty
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing reason "<reasonMessage>" for "<reason>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | reasonMessage | reason       |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | Outing Reason | outingReason |

  Scenario Outline: Enter Primary Contact Number for Out Duty
    When User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed
    Then Enter outing contact no "<primaryContactNo>" for "<primaryContact>" field

    Examples:
      | parentTab        | childTab | tab           | heading                                                  | primaryContactNo | primaryContact      |
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 9878787678       | outingContactNumber |

  Scenario Outline: Enter Data and Click on Submit for Out of Duty tab
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
      | Leave Management | Apply    | Out Duty/Tour | Apply Leave / WFH / Comp Off / Out Duty / Change Request | 03/10/2023 | outingFromDate | 04/10/2023 | outingTillDate | Tour (Overseas Visit) | outingType | Outing Reason | outingReason | 9878787678       | outingContactNumber | 9878787678     | outingAltContactNumber | Success   | Out Duty/Tour request has been applied successfully. |

  Scenario Outline: Navigate to Leave Management > WFH tab
    Then User clicks on "<childTab>" sub tab of "<parentTab>" tab in MIS
    And Verify "<heading>" of "<childTab>" tab
    And User clicks on "<tab>" Tab
    And Verify "<tab>" is displayed

    Examples:
      | parentTab        | childTab | tab            | heading                                                  |
      | Leave Management | Apply    | Work From Home | Apply Leave / WFH / Comp Off / Out Duty / Change Request |