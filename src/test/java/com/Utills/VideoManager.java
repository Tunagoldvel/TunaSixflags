package com.Utills;

import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.Utills.DriverSetUp.driver;


public class VideoManager {
    private final static Logger logger = Logger.getLogger(VideoManager.class);
    public void startRecording(){
        ((CanRecordScreen) DriverSetUp.getDriver()).startRecordingScreen();
    }

    public void stopRecording(String scenarioName) throws IOException {
        GlobalParameters params = new GlobalParameters();
        String media = ((CanRecordScreen) new getDriver()).stopRecordingScreen();
        String dirPath = params.getPlatformName() + "_"
                + params.getDeviceName() + File.separator +"Videos";

        File videoDir = new File(dirPath);

        synchronized(videoDir){
            if(!videoDir.exists()) {
                videoDir.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(videoDir + File.separator + scenarioName + ".mp4");
            stream.write(Base64.decodeBase64(media));
            stream.close();
           // TestUtills.log().info("video path: " + videoDir + File.separator + scenarioName + ".mp4");
        } catch (Exception e) {
            logger.error("error during video capture" + e.toString());
        } finally {
            if(stream != null) {
                stream.close();
            }
        }
    }

    private class getDriver {
    }
}
