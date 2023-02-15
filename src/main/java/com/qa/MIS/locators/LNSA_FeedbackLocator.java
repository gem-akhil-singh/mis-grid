package com.qa.MIS.locators;

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
    public static By LNSA_WEEK_SELECT = By.xpath("//input[contains(@id,'selectAll')]");
    public static By LNSA_WARNING_POP = By.xpath("//h2[text() = 'Warning']");

    public static By  feedbackHome = By.xpath("//span[text()= 'Feedback']");
    public static By  feedbackSubmit = By.xpath("//span[text()= 'Submit Feedback']");
    public static By  feedbackProvideFeedbackButton = By.xpath("//button[contains(text(), 'Provide')]");
    public static By  feedbackSubmitFeedbackTextbox = By.xpath("//textarea[contains(@placeholder, 'comments')]");
    public static By  feedbackSubmitFeedbackButton = By.xpath("//div[@class='modal-footer']//button[contains(@onClick, 'Feed')]");
    public static By feedbackSuccessMsg = By.xpath("//h2[text() ='Success']");
    public static By feedbackSuccessButton = By.xpath("//div[@class ='sa-confirm-button-container']/button");
    public static By feedbackNextButton = By.xpath("//a[text()='Next']/..");
    public static By feedbackPreviousButton = By.xpath("//a[text() ='Previous']/..");
    public static By feedbackSearchFeedback = By.xpath("//input[@type='search']");
}