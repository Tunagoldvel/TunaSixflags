package com.Utills;

public class GlobalParameters {
    private static ThreadLocal<String> platformName = new ThreadLocal();
    private static ThreadLocal<String> version = new ThreadLocal();
    private static ThreadLocal<String> deviceName = new ThreadLocal();
    private static ThreadLocal<String> appPackage = new ThreadLocal();
    private static ThreadLocal<String> appActivity = new ThreadLocal();
    private static ThreadLocal<String> systemAPort = new ThreadLocal();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal();
    private static ThreadLocal<String> webKitDebugProxyPort = new ThreadLocal();
    private static ThreadLocal<String> avd = new ThreadLocal();

    public void setPlatformName(String platformName1) { platformName.set(platformName1);  }
    public String getPlatformName() { return platformName.get(); }

    public void setVersion(String version1) { version.set(version1);  }
    public String getVersion() { return version.get(); }

    public void setDeviceName(String deviceName1) { deviceName.set(deviceName1);  }
    public String getDeviceName() { return deviceName.get(); }

    public void setAppPackage(String appPackage1) { appPackage.set(appPackage1);  }
    public String getAppPackage() { return appPackage.get(); }

    public void setAppActivity(String appActivity1) { appActivity.set(appActivity1);  }
    public String getAppActivity() { return appActivity.get(); }

    public void setSystemAPort(String systemAPort1) { systemAPort.set(systemAPort1);  }
    public String getSystemAPort() { return systemAPort.get(); }

    public void setWaLocalPort(String wdaLocalPort1) { wdaLocalPort.set(wdaLocalPort1);  }
    public String getWdaLocalPort() { return wdaLocalPort.get(); }

    public void setWebKitDebugProxyPort(String webKitDebugProxyPort1) { webKitDebugProxyPort.set(webKitDebugProxyPort1);  }
    public String getWebKitDebugProxyPort() { return webKitDebugProxyPort.get(); }

    public void initializeGlobalParameters(){
        GlobalParameters parameters = new GlobalParameters();
        parameters.setPlatformName(System.getProperty("platformName","Android"));
        parameters.setPlatformName(System.getProperty("appPackage","com.sixflags.android.snapshot"));
        parameters.setPlatformName(System.getProperty("appActivity","com.sixflags.android.MainActivity"));

        switch (parameters.getPlatformName()){
            case "ANDROID":
                parameters.setSystemAPort((System.getProperty("systemPort","8521")));
                parameters.setPlatformName(System.getProperty("deviceName","emulator-5554"));
                parameters.setPlatformName(System.getProperty("version","13.0"));

            case "IOS":
                parameters.setSystemAPort((System.getProperty("wdaLocalPort","7500")));
                parameters.setPlatformName(System.getProperty("webKitDebugProxyPort","8000"));
            default:
                throw new IllegalStateException("Platform should 'ANDROID' or 'IOS'");

        }


    }


}
