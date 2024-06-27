package com.Utills;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class DriverSetUp {

    static AppiumDriver driver;
    private static AppiumDriverLocalService service;
    private static Properties prop;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static Properties getProp() {
        if (prop == null) {
            prop();
        }
        return prop;
    }

    public static Properties prop() {
        prop = new Properties();
        try {
            prop.load(new FileInputStream("./config.properties"));
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return prop;
    }


    public static void initDriver() {


        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android").setDeviceName("emulator-5554").setPlatformVersion("13.0")
                .setAppPackage(getProp().getProperty("AndroidAppPackage")).setAppActivity(getProp().getProperty("AndroidAppActivity"))
                .setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName("UIAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true).setAvd("Pixel_6_13")
                .setAvdLaunchTimeout(Duration.ofSeconds(180)).showChromedriverLog();
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        URI uri = null;
        try {
            uri = new URI(service.getUrl().toString());
        } catch (URISyntaxException e) {
            System.out.println("Exception" + e);
        }
        URL url = null;
        try {
            assert uri != null;
            url = uri.toURL();
        } catch (MalformedURLException e) {

            System.out.println("Exception" + e);
        }
        System.out.println("Driver Setup on Before Hook");
        assert url != null;
        driver = new AppiumDriver(url, options);

    }

    public static void closeApp() {((InteractsWithApps) (driver)).terminateApp(getProp().getProperty("AndroidAppPackage")); }

    public static void launchApp() {((InteractsWithApps) (driver)).activateApp(getProp().getProperty("AndroidAppPackage")); }

    public static void tearDown()  {
        try {
            Thread.sleep(5000);
            if (driver != null) {
                driver.quit();
                System.out.println("Driver Quit");
            }
            service.stop();
            System.out.println("Service Stopped");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void manualInitDriver() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android").setDeviceName("emulator-5554").setPlatformVersion("13.0")
                .setAppPackage(getProp().getProperty("AndroidAppPackage")).setAppActivity(getProp().getProperty("AndroidAppActivity"))
                .setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName("UIAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true).setAvd("Pixel_6_13")
                .setAvdLaunchTimeout(Duration.ofSeconds(180));
        String host = getProp().getProperty("AppiumURL");

        URI uri = null;
        try {
            uri = new URI(host);
        } catch (URISyntaxException e) {
            System.out.println("Exception" + e);
        }
        URL url = null;
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {

            System.out.println("Exception" + e);
        }
        System.out.println("Driver Set");
        assert url != null;
        driver = new AppiumDriver(url, options);

    }
    public static String dateTine()  {
        DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY-HH-MM");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        return dateFormat.format(date);
    }
    @Parameters({"platformName", "platformVersion", "deviceName"})

    public static void manualInitDriver(String platformName, String platformVersion, String deviceName) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName(platformName).setDeviceName(deviceName).setPlatformVersion(platformVersion)
                .setAppPackage(getProp().getProperty("AndroidAppPackage")).setAppActivity(getProp().getProperty("AndroidAppActivity"))
                .setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName("UIAutomator2")
                .setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true).setAvd("Pixel_6_13")
                .setAvdLaunchTimeout(Duration.ofSeconds(180));
        String host = getProp().getProperty("AppiumURL");

        URI uri = null;
        try {
            uri = new URI(host);
        } catch (URISyntaxException e) {
            System.out.println("Exception" + e);
        }
        URL url = null;
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {

            System.out.println("Exception" + e);
        }
        System.out.println("Driver Set");
        assert url != null;
        driver = new AppiumDriver(url, options);

    }


}
