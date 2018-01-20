package Selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class ChromeDesiredCapabilities {

    WebDriver driver;
    @BeforeClass
    void setup(){
        System.out.println("Launching IE browser");
        System.setProperty("webdriver.chrome.driver","E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\webdriver\\IEDriverServer.exe");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");
        options.setProxy(proxy);
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
    }
}
