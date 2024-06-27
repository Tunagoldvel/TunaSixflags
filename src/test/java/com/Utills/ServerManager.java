package com.Utills;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {
    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public AppiumDriverLocalService getServer() {

        return server.get();
    }

    public void startServer() {
        AppiumDriverLocalService server = windowsDriver();
        server.start();
        if(server ==null || !server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not starter. Abort!!!");
        }
        server.clearOutPutStreams();
        this.server.set(server);

    }
    public AppiumDriverLocalService getAppiumDriverLocalService(){
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService windowsDriver() {
        GlobalParameters parameters = new GlobalParameters();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(parameters.getPlatformName() + "_"
                        + parameters.getDeviceName() + File.separator + "server.log")));
    }


}
