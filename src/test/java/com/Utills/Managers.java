package com.Utills;

import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Managers {
    static GlobalParameters parameters = new GlobalParameters();
    private static Properties properties = new Properties();
    private static UiAutomator2Options options = new UiAutomator2Options();

    public Properties getProps() throws IOException {
        InputStream is = null;
        String propFileName = "config.properties";
        if (properties.isEmpty()) {
            try {
                is = getClass().getClassLoader().getResourceAsStream(propFileName);
                properties.load(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        return properties;
    }

    public static UiAutomator2Options getOptions() {
        try {
            options.setPlatformName(parameters.getPlatformName()).setDeviceName(parameters.getDeviceName()).setPlatformVersion(parameters.getVersion())
                    .setAppPackage(parameters.getAppPackage()).setAppActivity(parameters.getAppActivity())
                    .setNoReset(true).setEnsureWebviewsHavePages(true).setAutomationName("UIAutomator2")
                    .setNewCommandTimeout(Duration.ofSeconds(20)).setNoReset(true).setAvd("Pixel_6_13")
                    .setAvdLaunchTimeout(Duration.ofSeconds(180));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return options;
    }
}
