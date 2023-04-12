package com.qa.mis.stepdefinition;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarConstants;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import static com.gemini.generic.ui.utils.DriverManager.setWebDriver;
import static oracle.jdbc.replay.OracleDataSource.URL;

public class Hook {
    @Before
    public void start() throws GemException, MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--incognito");
//        DriverManager.initializeChrome(options);
//        DriverAction.maximizeBrowser();
//        DriverAction.launchUrl("https://gembook.geminisolutions.com/#/");

        //firefox
        String remoteURL = GemJarUtils.getGemJarKeyValue(GemJarConstants.REMOTE_WEBDRIVER_URL);
        if (remoteURL == null) {
            remoteURL = GemJarConstants.DEFAULT_REMOTE_WEBDRIVER_URL;
        }
        System.out.println(remoteURL);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        options.addArguments("--incognito");
        options.addArguments("--window-size=1920,1080");//Scree Resolutions
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--dns-prefetch-disable");
        options.addArguments("--always-authorize-plugins");
        options.addArguments("enable-automation");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--headless");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //Experimental Option is Availble only on chrome
        options.setCapability("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setCapability("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36");
        //options.setCapability("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        WebDriver driver = remoteURL != null ? new RemoteWebDriver(new URL(remoteURL), options) : new RemoteWebDriver(options);
        setWebDriver(driver);
        DriverAction.launchUrl(GemJarUtils.getGemJarConfigData("launchUrl"));
        DriverAction.maximizeBrowser();
        // DriverAction.maximizeToDefaultBrowserSize();
        DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
        DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
        DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));


    }
}
