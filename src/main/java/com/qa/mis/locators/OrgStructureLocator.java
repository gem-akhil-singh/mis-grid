package com.qa.mis.locators;

import org.openqa.selenium.By;

public class OrgStructureLocator {

    public static By orbbtn= By.xpath("//div[@class='jspPane']//child::span[text()='Organization Structure']");
    public static By searchtab=By.xpath("//input[@placeholder='Search']");
    public static By getemp(String name){
        return By.xpath("//*[name()='svg']//*[local-name()='text' and text()='"+name+"']/..//*[local-name()='text'][2]");
    }
    public static By visibleEmp=By.xpath("//*[name()='svg']//*[local-name()='text']/..//*[local-name()='text'][1]");



}
