package configuration;

import driver.manager.BrowserType;

public class TestRunProperties {

    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }

    public static BrowserType getBrowserToRun(){
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    public static boolean getIsRemoteRun() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }

    public static boolean getHeadlessMode() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("headless.mode"));
    }



}
