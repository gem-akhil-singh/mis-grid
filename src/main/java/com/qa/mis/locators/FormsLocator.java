package com.qa.mis.locators;

import org.openqa.selenium.By;

public class FormsLocator {

    public static By userName = By.xpath("//input[@type='text' and @id='username']");
    public static By password = By.xpath("//input[@type='password' and @id='password']");
    public static By bttnSignUp = By.xpath("//input[@type='button' and @id='btnLogin']");
    public static By skillTypeBtn = By.xpath("//select[@id=\"ddlSkillType\"]");
    public static By geminiLogo = By.xpath("//img[@src='/img/GeminiLogo-Small-Black.png']");
    public static By leaveManagement = By.xpath("//span[contains(text(),'Leave Management')]");
    public static By closeBtn = By.xpath("//button[@id='btnskillsClose']");

    public static By forms = By.xpath("//span[contains(text(),'Forms')]");
    public static By next = By.xpath("//a[contains(text(),'Next')]");
    public static By previous = By.xpath("//a[contains(text(),'Previous')]");

    public static By viewForm = By.xpath("//span[contains(text(),'View Form')]");

    public static By department = By.xpath("//span[@title='All']");

    public static By accounts = By.xpath("//li[contains(text(),'Accounts')]");
    public static By entriesDropDown = By.xpath("//select[@name='tblActiveForm_length']");

    public static By selectEntriesValue(String type) {
        return By.xpath("//option[@value=" + "'" + type + "'" + "]");
    }

    public static By accountsType(String element) {
        return By.xpath("//td[contains(text()," + "'" + element + "'" + "]");
    }

    public static By searchBtn = By.xpath("//input[@type='search']");
    public static By noDataAvailable = By.xpath("//td[contains(text(),'No matching records found')]");
    public static By eyeBtn = By.xpath("//button[@data-target=\"#mypopupViewDocModal\" and @onclick=\"viewDocumentInPopup('Loyalty Redemption Form' , 'Loyalty Redemption Form.pdf' ,10)\"]");
    public static By policyCloseBtn = By.xpath("(//button[@type='button' and @class='close'])[1]");
    public static By documentDownload = By.xpath("//button[@class='btn btn-sm teal']");
    public static By myForms = By.xpath("//span[contains(text(),'My Form')]");
    public static By myFormsHeading = By.xpath("//h5[@class=\"with-border m-t-0\" and contains(text(),'My Forms')]");

    public static By uploadBtn = By.xpath("//button[@id=\"uploadForm\"]");
    public static By formTypeDropDown = By.xpath("//span[contains(text(),'Select') and @id=\"select2-departmentalForm-container\"]");

    public static By formType(String formTye) {

        return By.xpath("//ul[@class='select2-results__options']/*[text()='" + formTye + "']");
    }

    public static By saveBtn = By.xpath("//button[@id=\"btnSaveForm\"]");
    public static By chooseFile = By.xpath("//input[@id=\"fuForm\"]");
    public static By warningMsg = By.xpath("//p[contains(text(),'Invalid file selected. Supported extensions are .xlsx,.xls,.pdf')]");
    public static By okBtn = By.xpath("//button[contains(text(),'OK')]");
//    public static By deactivateBtn = By.xpath("//button[@data-original-title=\"DeActivate\"]");
public static By deactivateBtn = By.xpath("//button[@class=\"btn btn-sm btn-success\"]");
    public static By activeForm = By.xpath("(//td[contains(text(),'Loyalty Redemption Form.pdf')])[1]");
    public static By yesBtn = By.xpath("//button[@class=\"confirm btn btn-lg btn-danger\"]");

   public static By downloadBtn=By.xpath("//table//td[@class=' text-center']//i[contains(@class,'fa fa-download')]");

    public static By errorMsg = By.xpath("//p[contains(text(),'File with same name already exists')]");

}
