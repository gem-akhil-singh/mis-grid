package com.qa.mis.locators;

import org.openqa.selenium.By;

public class KnowledgeBaseLocator {
     public static By usernameByXpath = By.xpath("//input[@id='username']");
    public static By Location = By.xpath("//div[text()='IT Park, Panchkula']");
    public static By Dashboardheading = By.xpath("//span[text()='Dashboard']");
    public static By passwordByXpath = By.xpath("//input[@id='password']");
    public static By signInByXpath = By.xpath("//input[@id='btnLogin']");
    public static By closeSkills = By.id("btnskillsClose");
    //public static By closeSkills = By.className("close");
    public static By knowledgeBase = By.xpath("//span[text()='Knowledge Base']");
    public static By viewDocuments  = By.xpath("//span[text()='View Documents']");

    public static By addDocumentTag = By.xpath("//img[@title='Add New Document Tag']");
    public static By addFolder = By.xpath("//*[@id=\"img2\"]");
    public static By saveFolder = By.id("btnSaveGroup");
    public static By inputDocumentTag = By.id("txtTagName");

    public static By saveDocumentTag = By.id("btnSaveDocumentTag");

    public static By documentTagSuccessfullyAdded = By.xpath("//p[text()='Document tag Added Sucessfully']");

    public static By okButton = By.xpath("//button[text()='OK']");

    public static By documentTagWarningMessage = By.xpath("//p[text()='Please fill required field']");
    public static By attendanceMonth = By.xpath("//span[@id='select2-selectduration-container']");
    public static By folder = By.xpath("//a[text()='abc']");

    public static By addDocument = By.xpath("//a[text()='Add New document']");
    public static By deleteFolder = By.xpath("//a[text()='Delete']");

    public static By refresh = By.xpath("//img[@title='Refresh']");

    public static By upload = By.xpath("//input[@name='fileToUpload']");
    public static By invalidDoc = By.xpath("//p[text()='Invalid file selected. supported extensions are .xlsx,.xls,.pdf']");

    public static By search = By.xpath("//input[@type='search']");

    public static By searchDocument = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td[2]");
    public static By searchDocumentShared = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td[1]");

    public static By documentSearch = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td");
    public static By rename = By.xpath("//*[@id=\"myMenu\"]/li[4]/a");


    public static By dropdown = By.xpath("//*[@id=\"tbldocumentGridViewList_length\"]/label/select");

    public static By delete = By.xpath("//a[text()='Delete']");

    public static By titleSort = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/thead/tr/th[2]");

    public static By sortValue = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr[1]/td[2]");

    public static By dateSort = By.xpath("//*[@id=\"tbldocumentGridViewList\"]/thead/tr/th[4]");
    public static By titleById = By.id("txtDescription");
    public static By titleDescriptionById = By.id("txtFileDiscription");
    public static By tagClick = By.xpath("//*[@id=\"mypopupWindowAddNewDocumentModal\"]/div/div/div[2]/div[4]/div/div[2]/span/span[1]/span/ul");
    public static By tag = By.xpath("//*[@id=\"select2-txtDocumentTags-result-6efv-30035\"]");
    public static By viewSharedDocument  = By.xpath("//span[text()='View Shared Documents']");
    public static By dropdownSharedDocument = By.xpath("//*[@id=\"tblShareDocumentList_length\"]/label/select");

    public static By listInfo = By.xpath("//*[@id=\"tblShareDocumentList_info\"]");
    public static By noMatchFound = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td");

    public static By titleAsc = By.xpath("//*[@id=\"tblShareDocumentList\"]/thead/tr/th[1]");

     public static By titleAscEl = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr[1]/td[1]");
    public static By nextList = By.xpath("//a[text()='Next']");
    public static By previousList = By.xpath("//a[text()='Previous']");
    public static By viewDocument = By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td[5]/button");
     public static By verifyDocument = By.xpath("//h4[text()='View Document']");
}
