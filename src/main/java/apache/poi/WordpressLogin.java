package apache.poi;

import common.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordpressLogin {

    WebDriver driver;
    @Test(dataProvider = "wordpressData")
    public void loginToWordPress(String userName, String password) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //if(System.getProperty("os.name") .toLowerCase().indexOf("win")>0){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\webdriver\\chromedriver.exe");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-popup-blocking");
        Thread.sleep(2000);
        driver = new ChromeDriver(chromeOptions);
        //((FirefoxDriver)driver).manage().window().maximize();
        driver.manage().window().maximize();
        driver.get("http://demosite.center/wordpress/wp-login.php");

        driver.findElement(By.id("user_login")).sendKeys(userName);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        Thread.sleep(5000);
        org.testng.Assert.assertTrue(driver.getTitle().contains("Dashboard"),"user not able to login successfully");
        System.out.println("Page title verified - user able to login successfully");
    }

    @DataProvider(name="wordpressData")
    public Object[][] passData(){

        Object[][] data = new Object[3][2];

        data[0][0] = "admin1";
        data[0][1] = "demo1";

        data[1][0] = "admin";
        data[1][1] = "demo123";

        data[2][0] = "admin2";
        data[2][1] = "demo1234";

        return data;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
