package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;


public class InternetDesiredCapabilities {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.out.println("Launching IE browser");
        System.setProperty("webdriver.ie.driver","E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\webdriver\\IEDriverServer.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
        driver = new InternetExplorerDriver(capabilities);
        driver.manage().deleteAllCookies();
    }
}

