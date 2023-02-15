package com.qa.mis.stepdefinition;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.Before;

public class Hook {
    @Before    public void start() throws GemException {
        DriverManager.setUpBrowser();
        DriverAction.setImplicitTimeOut(2000);
        DriverAction.maximizeBrowser();
    }
}
