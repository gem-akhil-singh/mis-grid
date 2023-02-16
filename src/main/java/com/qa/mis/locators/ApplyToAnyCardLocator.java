package com.qa.mis.locators;

import org.openqa.selenium.By;

public class ApplyToAnyCardLocator {
    public static By cardNameBeta(String cardName) {
        return By.xpath("//header[@class='box-typical-header panel-heading']//*[text()='" + cardName + "']");
    }

    public static By minimiseMaximizeButton(String btn, String cardName) {
        if (btn.contains("minimize")) {
            return By.xpath("//*[text()='" + cardName + "']//parent::header[@class='box-typical-header panel-heading']//a[@data-title='Minimize']");
        }
        return By.xpath("//*[text()='" + cardName + "']//parent::header[@class='box-typical-header panel-heading']//a[@data-title='Fullscreen']");
    }

    public static By collapsedCard(String cardName) {
        return By.xpath("//section[contains(@class, 'panel-collapsed')]/header//*[text()='" + cardName + "']");
    }

    public static By expandedCard(String cardName) {
        return By.xpath("//section[contains(@class, 'panel-expanded')]//header//h3");
    }
}
