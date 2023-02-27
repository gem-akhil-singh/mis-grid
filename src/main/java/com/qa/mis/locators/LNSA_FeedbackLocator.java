package com.qa.mis.locators;

import org.openqa.selenium.By;

public class LNSA_FeedbackLocator {
    public static By geminiLogo = By.xpath("//img[contains(@src, 'Gemini')]");
    public static By txtUserName = By.xpath("//input[@id='username']");
    public static By txtPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//input[@id='btnLogin']");

    //----------------------------------LNSA Locators----------------------------------//

    public static By LNSA_HOME = By.xpath("//span[text()='LNSA']/..");
    public static By LNSA_APPLY_LNSA = By.xpath("//a[contains(@href, 'Lnsa/Apply')]/span");
    public static By LNSA_APPLY_TEXT = By.xpath("//h5[contains(text(), 'LNSA')]");
    public static By LNSA_VIEW_REQUEST_STATUS = By.xpath("//a[contains(@href, 'Lnsa/View')]/span");
    public static By LNSA_NEXT_BUTTON = By.xpath("//input[contains(@id,'Next')]");
    public static By LNSA_PREVIOUS_BUTTON = By.xpath("//input[contains(@id,'Previous')]");
    public static By LNSA_START_DATE = By.xpath("//span[@id='startDate']");
    public static By LNSA_END_DATE = By.xpath("//span[@id='endDate']");
    public static By LNSA_SUBMIT_BUTTON = By.xpath("//button[@id = 'btnReasonPop']");
    public static By LNSA_OK_BUTTON = By.xpath("//button[text() = 'OK']");
    public static By LNSA_WEEK_SELECT = By.xpath("(//input[contains(@id,'selectAll')])[3]");
    public static By LNSA_ANY_DAY_SELECT = By.xpath("//div[@class='lnsaNotApplied']");
    public static By LNSA_WARNING_POP = By.xpath("//h2[text() = 'Warning']");
    public static By LNSA_REASON_POPUP = By.xpath("//h2[text() = 'Warning']");
    public static By LNSA_REASON_TXTBOX = By.xpath("//div[@class='modal-content']//textarea");
    public static By LNSA_REASON_SUBMIT_BTN = By.xpath("//div[@class='modal-footer']//button[contains(text(), 'Submit')]");
    public static By LNSA_REASON_CANCEL_BTN = By.xpath("//div[@class='modal-footer']//button[@data-dismiss='modal']");
    public static By LNSA_REQUEST_TAB = By.xpath("//li[@class='active']//span[contains(text(), 'View Request')]");
    public static By LNSA_SEARCH_RESULTS = By.xpath("//tr[@role='row']//td[4]");
    public static By COLUMN_DATA(String columnName, String index){
        return By.xpath("//th[text()='"+columnName+"']/ancestor::thead/following-sibling::tbody/tr/td["+index+"]");
    }
    public static By LNSA_COLUMN_HEADER(String columnName){
        return By.xpath("//th[text()='"+columnName+"']");
    }
    public static By LNSA_VIEW_STATUS_DROPDOWN = By.name("tblLnsaStatusGrid_length");

    public static By  feedbackHome = By.xpath("//span[text()= 'Feedback']");
    public static By  feedbackSubmit = By.xpath("//span[text()= 'Submit Feedback']");
    public static By  feedbackProvideFeedbackButton = By.xpath("//button[contains(text(), 'Provide')]");
    public static By  feedbackSubmitFeedbackTextbox = By.xpath("//textarea[contains(@placeholder, 'comments')]");
    public static By  feedbackSubmitFeedbackButton = By.xpath("//div[@class='modal-footer']//button[contains(@onClick, 'Feed')]");
    public static By successMsg = By.xpath("//h2[text() ='Success']");
    public static By successButton = By.xpath("//div[@class ='sa-confirm-button-container']/button");
    public static By nextButton = By.xpath("//a[text()='Next']/..");
    public static By previousButton = By.xpath("//a[text() ='Previous']/..");
    public static By searchTextbox = By.xpath("//input[@type='search']");
    public static By feedbackSearchResultsRow = By.xpath("//td[@tabindex='0']");
    public static By searchResultsTotal = By.xpath("//div[contains(text(),'Showing')]");
    public static By searchResultsEmpty = By.xpath("//td[@class='dataTables_empty']");
    public static By exportButton = By.xpath("//span[text()= 'Export']/..");
    public static By exportOptionCopy = By.xpath("//span[text()= 'Copy']/..");
    public static By exportOptionExcel = By.xpath("//span[text()= 'Excel']/..");
    public static By exportOptionPDF = By.xpath("//span[text()= 'PDF']/..");
    public static By exportOptionPrint = By.xpath("//span[text()= 'Print']/..");
    public static By viewIcon = By.xpath("//tr//td/following::td//button[@title='View ']");
    public static By viewIcon1 = By.xpath("//tr//td/following::td//button[@title='View']");
    public static By popupHeader(String headerText){ return By.xpath("//h4[text() = '"+headerText+"']");}
    public static By closeButtonOfViewFeedback = By.xpath("//div[@id='modal-feedback']//button[contains(@class,'Close')]");
    public static By closeButtonOfViewLNSA = By.xpath("//div[@id='dateLnsaModal']//button[contains(text(),'Close')]");


}