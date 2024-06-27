package com.Utills;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.Base64;
import java.util.Date;




public class Listener implements ITestListener {
    String dateTime = DriverSetUp.dateTine();
    String videoData;
    static GlobalParameters parameters = new GlobalParameters();


    public void onTestStart(ITestResult result) {
        System.out.println("Test Start");
        videoData = ((CanRecordScreen) DriverSetUp.getDriver()).stopRecordingScreen();

    }


    public void onTestSuccess(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String timestamp = new Date().getTime() + ""; // Convert timestamp to String

            String filename = methodName + "_" + timestamp + ".png";
            String filePath = System.getProperty("user.dir") + "/target/ScreenshotTestPass" + filename;

            File screenshot = ((TakesScreenshot) DriverSetUp.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(filePath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Screenshot captured for Passes test: " + methodName);
        }
    }

    public void  onFinish(ITestContext context) {

        videoData = ((CanRecordScreen) DriverSetUp.getDriver()).stopRecordingScreen();


        String dir = "target" + File.separator + "Recording" + File.separator + parameters.getDeviceName()+ dateTime;
        File videoDir = new File(dir);

        System.out.println("Test end");
        if (!videoDir.exists()) {
            videoDir.mkdirs();
        }

        String videoExtension = ".mp4"; // Assuming video format is MP4, adjust if needed
        try (FileOutputStream stream = new FileOutputStream(new File(videoDir, "recording" + videoExtension))) {
            stream.write(Base64.getDecoder().decode(videoData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onTestFailure(ITestResult result) {
        if(result.getThrowable()!=null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }





    }

}
