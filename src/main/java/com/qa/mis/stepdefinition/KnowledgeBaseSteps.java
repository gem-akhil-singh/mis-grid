package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.KnowledgeBaseLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;

public class KnowledgeBaseSteps {
    static WebElement el;

    @Given("logged in successfully")
    public void logged_in_successfully() throws InterruptedException {

        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(KnowledgeBaseLocator.usernameByXpath)) {
                DriverAction.typeText(KnowledgeBaseLocator.usernameByXpath, "prajjwal.negi");
            } else {
                GemTestReporter.addTestStep("Username", "Username field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(KnowledgeBaseLocator.passwordByXpath)) {
                DriverAction.typeText(KnowledgeBaseLocator.passwordByXpath, "Gemini@123");
            } else {
                GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.click(KnowledgeBaseLocator.signInByXpath);
            Thread.sleep(10000);
            // DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.closeSkills,100);

            DriverAction.click(KnowledgeBaseLocator.closeSkills, "Close skill");
        }catch (Exception e){
            GemTestReporter.addTestStep("User enters the  username and password", "Username/Password not entered successfully", STATUS.FAIL);

        }}
    @When("navigating to view documents page")
    public void navigating_to_view_documents_page() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);

        }catch (Exception e){
            GemTestReporter.addTestStep("user clicks on View Documents", "View Document is not clicked successfully", STATUS.FAIL);
        }}
    @Then("add new document tags icon is present and functional")
    public void add_new_document_tags_icon_is_present_and_functional() {
        try {
            DriverAction.click(KnowledgeBaseLocator.addDocumentTag, "Add document Tag");
            Thread.sleep(3000);
            DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag, "Test113");
            DriverAction.click(KnowledgeBaseLocator.saveDocumentTag, "Document Tag saved");
            String successMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagSuccessfullyAdded);

            if (!successMessage.equalsIgnoreCase("Document tag Added Sucessfully")) {
                Assert.fail();
            }

            DriverAction.click(KnowledgeBaseLocator.okButton, "Ok button");

        } catch (Exception e)
        {
            GemTestReporter.addTestStep("User enters the new document tag", "document tag not added successfully ", STATUS.FAIL);

        }
    }

    @When("navigating to view documents page adding empty document tag")
    public void navigating_to_view_documents_page_adding_empty_document_tag() throws InterruptedException {
        try {
            DriverAction.click(KnowledgeBaseLocator.closeSkills, "Close skill");
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase, "Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments, "View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.addDocumentTag, "Add document Tag");
            DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag, "");
            DriverAction.click(KnowledgeBaseLocator.saveDocumentTag, "Document Tag saved");
        }catch (Exception e){
            GemTestReporter.addTestStep("Adding empty document tag", "Empty document tag not addedd successfully", STATUS.FAIL);
        }


    }
    @Then("throws warning message")
    public void throws_warning_message() {
        try {
            String warningMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagWarningMessage);
            System.out.println(warningMessage);
            if (warningMessage.equalsIgnoreCase("Please fill required field")) {


            } else {
                Assert.fail();
            }
        }catch (Exception e){
            GemTestReporter.addTestStep("User sees the warning message", "Warning message not displayed successfully", STATUS.FAIL);

        }





    }

    @When("navigating to my attendance")
    public void navigating_to_my_attendance() {
        try {
            DriverAction.click(KnowledgeBaseLocator.attendanceMonth, "Attendance Month Selection");
        }
        catch(Exception e){
            GemTestReporter.addTestStep("User clicks on attendance", "Clicking on attendance not successful", STATUS.FAIL);
        }
    }
    @Then("selecting {string} and verifying the attendance")
    public void selecting_and_verifying_the_attendance(String month) throws InterruptedException {
        try{
            DriverAction.click(By.xpath("//li[text()='"+month+"'"+"]"));


        }catch (Exception e){
            GemTestReporter.addTestStep("User verifies the attendance", "attendance not verified successfully", STATUS.FAIL);

        }}

    @Then("right click functionality is working")
    public void right_click_functionality_is_working() throws InterruptedException {
        try{
            Thread.sleep(5000);
            DriverAction.rightClick(KnowledgeBaseLocator.folder);
            if(!DriverAction.isExist(KnowledgeBaseLocator.deleteFolder)){
                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User right clicks on a folder", "User right clicking on folder not successful ", STATUS.FAIL);
        }}

    @When("navigating to view documents page and adding an invalid document type")
    public void navigating_to_view_documents_page_and_adding_an_invalid_document_type() throws InterruptedException {
        try{
            System.out.println(System.getProperty("user.dir"));
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(KnowledgeBaseLocator.folder);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.addDocument,"Add Document");
            Thread.sleep(5000);
            DriverAction.fileUpload(KnowledgeBaseLocator.upload,System.getProperty("user.dir")+"\\src\\main\\resources\\testdocument2.txt");
            Thread.sleep(5000);






        }catch (Exception e){
            GemTestReporter.addTestStep("User uploads an invalid document", "Invalid document upload not successful", STATUS.FAIL);
        }}
    @Then("invalid document type warning should be displayed")
    public void invalid_document_type_warning_should_be_displayed() {
        try{
            if(DriverAction.getElementText(KnowledgeBaseLocator.invalidDoc).equalsIgnoreCase("Invalid file selected. supported extensions are .xlsx,.xls,.pdf")){

            }
            else{
                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User gets a warning message after uploading invalid file", "Not getting a warning message", STATUS.FAIL);
        }}

    @When("navigating to view documents page and page is refreshed")
    public void navigating_to_view_documents_page_and_page_is_refreshed() {

        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.click(KnowledgeBaseLocator.refresh,"refresh");

        }catch (Exception e){
            GemTestReporter.addTestStep("User refreshes the view document page", "View document page refresh not successful", STATUS.FAIL);
        }}
    @Then("page is refreshed")
    public void page_is_refreshed() {
        try{
            if(!DriverAction.isExist(KnowledgeBaseLocator.folder)){
                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User refreshed the page", "view document page not refreshed successfully", STATUS.FAIL);
        }}

    @When("navigating to view documents page and searched")
    public void navigating_to_view_documents_page_and_searched() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);

        }catch (Exception e){
            GemTestReporter.addTestStep("User navigates to view document", "user not able to navigate to view document", STATUS.FAIL);

        }}
    @Then("search is functional")
    public void search_is_functional() {
        try{
            DriverAction.typeText(KnowledgeBaseLocator.search,"xyz");
            String documentName = DriverAction.getElementText(KnowledgeBaseLocator.searchDocument);
            if(documentName.equalsIgnoreCase("xyz")){

            }
            else{
                Assert.fail();
            }





        }catch (Exception e){
            GemTestReporter.addTestStep("User searches for a document", "User not able to search a document successfully", STATUS.FAIL);

        }}


    @When("navigating to view documents page and searched document not present")
    public void navigating_to_view_documents_page_and_searched_document_not_present() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);

        }catch (Exception e){
            GemTestReporter.addTestStep("User navigates to view document", "user not able to navigate to view document", STATUS.FAIL);
        }}
    @Then("search is functional and nothing is shown")
    public void search_is_functional_and_nothing_is_shown() {
        try{
            DriverAction.typeText(KnowledgeBaseLocator.search,"xyz2");
            String mismatch = DriverAction.getElementText(KnowledgeBaseLocator.documentSearch);
            if(mismatch.equalsIgnoreCase("No matching records found")){

            }
            else{
                Assert.fail();
            }


        }catch (Exception e){
            GemTestReporter.addTestStep("User searches for an invalid document", "Search mismatch unsuccessful", STATUS.FAIL);
        }}

    @When("navigating to view documents page and renaming the {string}")
    public void navigating_to_view_documents_page_and_renaming_the(String folderRename) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(By.xpath("//a[text()='"+folderRename+"']"));
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.rename);
            Thread.sleep(5000);





        }catch(Exception e){
            GemTestReporter.addTestStep("User renames the folder", "user not able to rename the folder", STATUS.FAIL);
        }}
    @Then("the folder name should be renamed")
    public void the_folder_name_should_be_renamed() {


    }

    @When("navigating to view documents page and selecting {string} from dropdown")
    public void navigating_to_view_documents_page_and_selecting_from_dropdown(String string) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            WebElement el = DriverAction.getElement(KnowledgeBaseLocator.dropdown);
            Select list = new Select(el);
            list.selectByValue(string);
            Thread.sleep(5000);





        }catch(Exception e){
            GemTestReporter.addTestStep("User selects a document from dropdown", "user not able select from the dropdown and is not functional ", STATUS.FAIL);
        }}
    @Then("dropdown is functional")
    public void dropdown_is_functional() throws InterruptedException {



    }

    @When("navigating to view document and {string} is selected")
    public void navigating_to_view_document_and_is_selected(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
            Thread.sleep(5000);
            //DriverAction.click(KnowledgeBaseLocator.delete);


        }catch(Exception e){
            GemTestReporter.addTestStep("User right clicks to delete  the folder", "user not able to delete the folder", STATUS.FAIL);
        }}
    @Then("folder is deleted")
    public void folder_is_deleted() {

    }


    @When("navigating to view document and {string} is selected and {string} is selected")
    public void navigating_to_view_document_and_is_selected_and_is_selected(String string, String string2) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.click(By.xpath("//a[text()='"+string+"']"));
            Thread.sleep(5000);
            DriverAction.rightClick(By.xpath("//a[text()='"+string2+"']"));
            Thread.sleep(5000);
        }catch(Exception e){
            GemTestReporter.addTestStep("User deletes the subfolder in view document", "user not able to delete the subfolder in view document", STATUS.FAIL);

        }}
    @Then("sub folder is deleted")
    public void sub_folder_is_deleted() {

    }

    @When("navigating to view document and title sort applied")
    public void navigating_to_view_document_and_title_sort_applied() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.titleSort);
            DriverAction.click(KnowledgeBaseLocator.titleSort);
            Thread.sleep(5000);
            if(DriverAction.getElementText(KnowledgeBaseLocator.sortValue).equalsIgnoreCase("zyx")){

            }else{
                Assert.fail();
            }

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the title sort", "title sort applied in view document not successful", STATUS.FAIL);
        }}
    @Then("list is sorted according to title")
    public void list_is_sorted_according_to_title() {

    }

    @When("navigating to view document and date sort applied")
    public void navigating_to_view_document_and_date_sort_applied() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.titleSort);
            DriverAction.click(KnowledgeBaseLocator.titleSort);
            Thread.sleep(5000);

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the date sort", "date sort applied in view document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted according to date")
    public void list_is_sorted_according_to_date() {

    }

    @When("navigating to view document and adding folder")
    public void navigating_to_view_document_and_adding_folder() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);

            DriverAction.click(KnowledgeBaseLocator.addFolder);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.saveFolder);


        }catch(Exception e){
            GemTestReporter.addTestStep("User add the folder in view document", "adding the folder in view document not successful", STATUS.FAIL);

        }}
    @Then("folder is added successfully")
    public void folder_is_added_successfully() throws InterruptedException {


    }

    @When("navigating to view document and adding subfolder to {string}")
    public void navigating_to_view_document_and_adding_subfolder_to(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
            Thread.sleep(5000);
            DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"));
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.saveFolder);



        }catch(Exception e){
            GemTestReporter.addTestStep("User add the sub folder in view document", "adding the sub folder in view document not successful", STATUS.FAIL);

        }}
    @Then("sub folder is added successfully")
    public void sub_folder_is_added_successfully() {

    }

    @When("navigating to view document and adding folder with duplicate name")
    public void navigating_to_view_document_and_adding_folder_with_duplicate_name() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);

            DriverAction.click(KnowledgeBaseLocator.addFolder);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.saveFolder);

        }catch (Exception e){
            GemTestReporter.addTestStep("User add the folder with duplicate name in view document", "adding the folder with duplicate name in view document not successful", STATUS.FAIL);

        }}
    @Then("warning is given for duplicate name")
    public void warning_is_given_for_duplicate_name() {

    }

    @When("navigating to view document and adding subfolder with duplicate name to {string}")
    public void navigating_to_view_document_and_adding_subfolder_with_duplicate_name_to(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            Thread.sleep(5000);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
            Thread.sleep(5000);
            DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"));
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.saveFolder);
        }catch(Exception e){
            GemTestReporter.addTestStep("User add the subfolder folder with duplicate name in view document", "adding the subfolder with duplicate name in view document not successful", STATUS.FAIL);

        }}
    @Then("warning is given for duplicate subfolder")
    public void warning_is_given_for_duplicate_subfolder() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("navigating to view documents page and adding an valid document type")
    public void navigating_to_view_documents_page_and_adding_an_valid_document_type() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            Thread.sleep(5000);
            DriverAction.rightClick(KnowledgeBaseLocator.folder);
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.addDocument,"Add Document");
            Thread.sleep(5000);
            DriverAction.fileUpload(KnowledgeBaseLocator.upload,System.getProperty("user.dir")+"\\src\\main\\resources\\testdocument1.xlsx");
            //DriverAction.typeText(Locators.upload,"src\\main\\resources\\testdocument2.txt");
            Thread.sleep(5000);



        }catch(Exception e){
            GemTestReporter.addTestStep("User adds a valid document in view document", "adding the valid document in view document not successful", STATUS.FAIL);

        }}
    @Then("document is added successfully")
    public void document_is_added_successfully() throws InterruptedException {


    }

    @When("navigating to view shared documents page and selecting {string} from dropdown")
    public void navigating_to_view_shared_documents_page_and_selecting_from_dropdown(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            WebElement el1 = DriverAction.getElement(KnowledgeBaseLocator.dropdownSharedDocument);
            Select list = new Select(el1);
            list.selectByValue(string);
            Thread.sleep(5000);
            if(DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains(string)){


            }
            else{
                Assert.fail();
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("User selects from a dropdown in view shared document", "Selecting dropdown in view shared document not successful", STATUS.FAIL);

        }}
    @Then("dropdown is functional in view shared")
    public void dropdown_is_functional_in_view_shared() {

    }

    @When("navigating to view shared documents page and searching a {string}")
    public void navigating_to_view_shared_documents_page_and_searching_a(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.typeText(KnowledgeBaseLocator.search,string);
            Thread.sleep(2000);
            String documentName = DriverAction.getElementText(KnowledgeBaseLocator.searchDocumentShared);
            if(documentName.equalsIgnoreCase(string)){

            }
            else{
                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User searches for a document in view shared document", "Searching document in view shared document not successful", STATUS.FAIL);

        }}
    @Then("search functionlity is working")
    public void search_functionlity_is_working() {

    }

    @When("navigating to view shared documents page and searching an absent  {string}")
    public void navigating_to_view_shared_documents_page_and_searching_an_absent(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.typeText(KnowledgeBaseLocator.search,string);
            Thread.sleep(2000);
            String documentName = DriverAction.getElementText(KnowledgeBaseLocator.noMatchFound);
            if(documentName.equalsIgnoreCase("No matching records found")){

            }
            else{
                Assert.fail();
            }

        }catch(Exception e){
            GemTestReporter.addTestStep("User makes an empty search in view shared document", "Empty search in view shared document not successful", STATUS.FAIL);

        }}
    @Then("search functionlity is working by displaying no document")
    public void search_functionlity_is_working_by_displaying_no_document() {

    }

    @When("navigating to view shared documents page and applying ascending title sort")
    public void navigating_to_view_shared_documents_page_and_applying_ascending_title_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.titleAsc);
            if(DriverAction.getElementText(KnowledgeBaseLocator.titleAscEl).equalsIgnoreCase("An introduction to Python for absolute beginners")){


            }
            else{
                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted ascendingly")
    public void list_is_sorted_ascendingly() {

    }

    @When("navigating to view shared documents page and applying descending title sort")
    public void navigating_to_view_shared_documents_page_and_applying_descending_title_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.titleAsc);
            Thread.sleep(2000);
            DriverAction.click(KnowledgeBaseLocator.titleAsc);
            if(DriverAction.getElementText(KnowledgeBaseLocator.titleAscEl).equalsIgnoreCase("Unix Tutorials")){


            }
            else{
                Assert.fail();
            }

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted descendingly")
    public void list_is_sorted_descendingly() {

    }

    @When("navigating to view shared documents page and clicking on next button")
    public void navigating_to_view_shared_documents_page_and_clicking_on_next_button() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.nextList);
            if(DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains("11")){


            }
            else{
                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User clicks on next button in view shared document", "Clicking on next button in view shared document not successful", STATUS.FAIL);

        }}
    @Then("next page of list is displayed")
    public void next_page_of_list_is_displayed() {


    }

    @When("navigating to view shared documents page and clicking on previous button")
    public void navigating_to_view_shared_documents_page_and_clicking_on_previous_button() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.nextList);
            if(DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains("11")){
                Thread.sleep(2000);
                DriverAction.click(KnowledgeBaseLocator.previousList);
                if(DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains("1")){

                }
                else{
                    Assert.fail();
                }


            }else{
                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User clicks on previous button in view shared document", "Clicking on previous button in view shared document not successful", STATUS.FAIL);

        }}
    @Then("previous page of list is displayed")
    public void previous_page_of_list_is_displayed() {

    }

    @When("navigating to view shared documents page and viewing the {string}")
    public void navigating_to_view_shared_documents_page_and_viewing_the(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.typeText(KnowledgeBaseLocator.search,string);
            Thread.sleep(2000);


        }catch(Exception e){
            GemTestReporter.addTestStep("User opens a document in view shared document", "Opening a document in view shared document not successful", STATUS.FAIL);

        }}
    @Then("document is opened")
    public void document_is_opened() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.viewDocument);
            Thread.sleep(5000);
            if(DriverAction.isExist(KnowledgeBaseLocator.verifyDocument)){}
            else{
                Assert.fail();
            }

        }catch(Exception e){
            GemTestReporter.addTestStep("Document opens in view shared document", "Document opened in view shared document not successful", STATUS.FAIL);

        }}

    ///////////////////////////////////////////////////////////////
    @When("navigating to view shared documents page and applying ascending shared by sort")
    public void navigating_to_view_shared_documents_page_and_applying_ascending_shared_by_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.sharedAscEl).equalsIgnoreCase("Amrita Tiwari")){
                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted by shared ascendingly")
    public void list_is_sorted_by_shared_ascendingly() {

    }

    @When("navigating to view shared documents page and applying descending shared by sort")
    public void navigating_to_view_shared_documents_page_and_applying_descending_shared_by_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc);
            Thread.sleep(2000);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.sharedAscEl).equalsIgnoreCase("Rahul Paul")){
                Assert.fail();

            }
        }catch(Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);


        }}
    @Then("list is sorted by shared descendingly")
    public void list_is_sorted_by_shared_descendingly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }




    @When("navigating to view shared documents page and applying ascending tag  sort")
    public void navigating_to_view_shared_documents_page_and_applying_ascending_tag_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.tagAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.tagAscEl).equalsIgnoreCase("Autosys")){
                Assert.fail();
            }



        }catch (Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted by tag ascendingly")
    public void list_is_sorted_by_tag_ascendingly() {


    }

    @When("navigating to view shared documents page and applying descending tag  sort")
    public void navigating_to_view_shared_documents_page_and_applying_descending_tag_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.tagAsc);
            Thread.sleep(2000);
            DriverAction.click(KnowledgeBaseLocator.tagAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.tagAscEl).equalsIgnoreCase("Unix Tutorial, finance")){
                Assert.fail();

            }

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted by tag descendingly")
    public void list_is_sorted_by_tag_descendingly() {

    }


    @When("navigating to view shared documents page and applying ascending date sort")
    public void navigating_to_view_shared_documents_page_and_applying_ascending_date_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.dateAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.dateAscEl).equalsIgnoreCase("31-Mar-2015")){
                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted by date ascendingly")
    public void list_is_sorted_by_date_ascendingly() {

    }

    @When("navigating to view shared documents page and applying descending date sort")
    public void navigating_to_view_shared_documents_page_and_applying_descending_date_sort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            Thread.sleep(5000);
            DriverAction.click(KnowledgeBaseLocator.dateAsc);
            Thread.sleep(2000);
            DriverAction.click(KnowledgeBaseLocator.dateAsc);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.dateAscEl).equalsIgnoreCase("12-Sep-2018")){
                Assert.fail();

            }

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("list is sorted by date descendingly")
    public void list_is_sorted_by_date_descendingly() {

    }
}
