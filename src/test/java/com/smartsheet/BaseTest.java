package com.smartsheet;

import com.smartsheet.helper.User;
import com.smartsheet.page.LoginPage;
import com.smartsheet.page.SheetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static User user;

    protected static LoginPage loginPage;
    protected static SheetPage sheetPage;

    @BeforeClass()
    public void setUp() {

        String driverPath = "/Users/oleksandr/automation/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String url = "https://app.smartsheet.com/b/home";
        driver.get(url);

        wait = new WebDriverWait(driver, 10);

        //verify that page is displayed
        if (!wait.until(ExpectedConditions.titleContains("Log In | Smartsheet")) ||
                !wait.until(ExpectedConditions.urlContains(url)))
            throw new RuntimeException("Page is not displayed");


        String currentTitle = driver.getTitle();
        Assert.assertEquals("Log In | Smartsheet", currentTitle);

        loginPage = new LoginPage(driver);

        user = new User();

    }

    @AfterClass()
    public void tearDown() {
        driver.quit();
    }


}
