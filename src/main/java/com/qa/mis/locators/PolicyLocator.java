package com.qa.mis.locators;

import org.openqa.selenium.By;

public class PolicyLocator {
    public static By policyButton=By.xpath("//span[contains(text(),'Policy')]");
    public static By viewPolicyButton=By.xpath("//span[contains(text(),'View Policies')]");
    public static By policyTabTitle=By.xpath("//div[@class='card-block']//h5[text()='View Policies']");
    public static By policyTableData=By.xpath("//table[@id='tblActivePolicy']/tbody//td[1]");
}
