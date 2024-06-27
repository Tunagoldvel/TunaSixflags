package com.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected AppiumDriver driver;
    protected Properties prop;
    InputStream inputStream;

    public BaseTest() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @BeforeTest
    public void BeforeSuite() {
        try {
            prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);


            AppiumDriverLocalService service;
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android").setDeviceName("emulator-5554").setPlatformVersion("13.0")
                    .setAppPackage(prop.getProperty("AndroidAppPackage")).setAppActivity(prop.getProperty("AndroidAppActivity"))
                    .setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName(prop.getProperty("AutomationName"))
                    .setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true).setAvd("Pixel_6_13")
                    .setAvdLaunchTimeout(Duration.ofSeconds(180)).showChromedriverLog();
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
            service.start();
            URI uri = new URI(service.getUrl().toString());
            URL url = uri.toURL();
            System.out.println("Driver Setup on Before Hook");
            driver = new AppiumDriver(url, options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void waitForVisibility(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void click(WebElement ele) {
        waitForVisibility(ele);
        ele.click();
    }

    public void sentKeys(WebElement ele, String txt) {
        waitForVisibility(ele);
        ele.click();
        ele.sendKeys(txt);
    }

    public void getAttribute(WebElement ele, String txt) {
        waitForVisibility(ele);
        ele.getAttribute(txt);
    }


    @AfterTest
    public void AfterSuite() {
        driver.quit();

    }


}
