package apache.poi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class WordpressLoginExcel {

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
    public Object[][] passData() throws IOException {

        ExcelDataConfig excelDataConfig = new ExcelDataConfig("E:\\Sridhar\\AutomationFolder\\AutomationBySridhar\\SeleniumProgramms\\src\\main\\resources\\DataFiles\\TestData.xlsx");

        int rows = excelDataConfig.getRowCount(0);


        Object[][] data = new Object[rows][2];

        for(int i = 0; i < rows; i++) {
            data[i][0] = excelDataConfig.getData(0, i, 0);
            data[i][1] = excelDataConfig.getData(0, i, 1);
        }
        return data;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
