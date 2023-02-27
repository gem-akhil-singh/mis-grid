package com.qa.mis.locators;

import org.openqa.selenium.By;

public class AppraisalManagementLocator {

    //login screen
    public static By txtUserName = By.xpath("//input[@id='username']");
    public static By txtPassword = By.xpath("//input[@id='password']");
    public static By btnSignIn = By.xpath("//input[@id='btnLogin']");
    public static By homePageLogo = By.xpath("//img[@class='hidden-md-down']");
    public static By errorUserName = By.xpath("//span[contains(text(),'Username is required')]");

    // Add goal page
    public static By lnkApraisalMgmnt = By.xpath("//span[contains(text(),'Appraisal Management')]");
    public static By lnkAddGoals = By.xpath("//span[contains(text(),'Add Goals')]");
    public static By tableGoalSet = By.xpath("//table[@id='tblSelfGoalList']");
    public static By addGoalsWindow = By.xpath("//h5[contains(text(),'Add My Goal/Team Goal')]");
    public static By tabMyGoal = By.xpath("//span[contains(text(),'My Goal')]");
    public static By lnkKRA_KPI = By.xpath("//a[contains(text(),'List of KRAs and KPIs')]");
    public static By drpdownFinancialYear = By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    public static By elementsdrpFinancialYear = By.xpath("//li[contains(@class,'select2-results__option')]");
    public static By btnAddNewKRAKPIMapping = By.xpath("//button[contains(text(),'Add New KRA/KPI Mapping')]");
    public static By popupWarning = By.xpath("//h2[contains(text(),'Warning')]");
    public static By btnOKWarning = By.xpath("//button[contains(text(),'OK')and @class='confirm btn btn-lg btn-primary']");
    public static By btnCloseKPI = By.xpath("//button[contains(text(),'X')and @class='btn btn-danger']");

    public static By drpdownGoalType = By.xpath("//span[@id='select2-userGoalName-container']");
    public static By txtKRA = By.xpath("//input[@id='userKraName']");
    public static By btnAddKPI = By.xpath("//a[@id='btnUserAddNewKPI']");
    public static By btnSubmit = By.xpath("//button[@id='btnUserSaveGoals']");
    public static By txtKPIDescription = By.xpath("//input[@placeholder='KPI description']");
    public static By btnKPIClose = By.xpath("//button[@class='btn btn-danger']");
    public static By btnClose = By.xpath("(//button[@class='btn btn-default btnClose'])[10]");
    public static By kRAList = By.xpath("//li[@class='select2-results__option']");
    public static By KPISuccessOK = By.xpath("//button[@class='confirm btn btn-lg btn-primary' and contains(text(),'OK')]");
    // Verify searches

    public static By btnSearch = By.xpath("//input[@type='search']");
    public static By tableRowCount = By.xpath("//tbody//tr[@role='row']");
    public static By searchEntriesCount = By.xpath("//div[@id='tblSelfGoalList_info']");
    //Export button functionality
    public static By btnExport = By.xpath("//span[contains(text(),'Export')]");
    public static By lstExport = By.xpath("//div[@class='dt-button-collection']//a");
    public static By drpdownPages = By.xpath("//select[@name='tblSelfGoalList_length']");
    public static By background = By.xpath("//div[@class='dt-button-background']");

    // Delete functionality
    public static By btnDelete = By.xpath("//i[@class='fa fa-trash']");
    public static By windowRemarks = By.xpath("//h4[contains(text(),'Remarks')]");
    public static By btnSubmitRemark = By.xpath("(//button[@class='btn btn-success'])[12]");
    public static By btnCloseRemark = By.xpath("(//button[@class='btn btn-default btnClose'])[8]");
    public static By windowConfirm = By.xpath("(//div[@class='sweet-alert  showSweetAlert visible'])");
    public static By btnYesConfirm = By.xpath("//button[@class='confirm btn btn-lg btn-danger']");
    public static By statusSuccess = By.xpath("//p[contains(text(),'Request processed successfully')]");
    public static By btnOkaySuccess = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");

    //Page navigation
    public static By pageList = By.xpath("//ul[@class='pagination']/li");
    public static By txtEnterRemarks = By.xpath("(//textarea[@placeholder='Enter remarks'])[4]");

    //Draft button functionality
    public static By btnAddUpdateGoal = By.xpath("//button[contains(text(),'Add/Update Goals')]");
    public static By titleAddGoal = By.xpath("(//h4[@id='modalTitle' and contains(text(),'Add goal')])[1]");
    public static By btnPlus = By.xpath("//a[@class='btn btn-primary pull-left' and @id='btnAddPro0']");
    public static By drpdownKPI = By.xpath("(//span[contains(text(),'None selected')])[3]");
    public static By drpdownKPIValue = By.xpath("//button[@aria-expanded='true']/following-sibling::ul//input[@value='multiselect-all']");
    public static By btnDraft = By.xpath("(//button[@class='btn btn-success' and contains(text(),'Draft')])[2]");

    // public static By txtboxProjectList=By.xpath("//textarea[@value='Project Name']");
    public static By bodyPath = By.xpath("//body[@class='with-side-menu control-panel control-panel-compact chrome-browser modal-open']");
    public static By btnDraftClose = By.xpath("(//button[@class='btn btn-default btnClose' and contains(text(),'Close')])[6]");
    public static By txtboxProject = By.xpath("//textarea[@class='form-control error-validation' and @value='Project Name']");
    public static By txtGoalDescription = By.xpath("//textarea[@class='form-control error-validation' and @value='Goal Description']");

    //submit goal
    public static By btnSubmitGoal = By.xpath("//button[@id='btnSaveGoal']");
    public static By popupConfirm = By.xpath("//p[contains(text(),'This will submit all the draft goals. They cannot be modified further')]");
    public static By btnYesConfirmGoal = By.xpath("//button[contains(text(),'Yes')]");

    //Sort Column
    public static By rowListSort = By.xpath("//thead//tr[@role='row']/th");



}



