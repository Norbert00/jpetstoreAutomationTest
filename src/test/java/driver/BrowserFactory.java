package driver;

import configuration.LocalWebDriverProperties;
import configuration.TestRunProperties;
import driver.manager.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER = "Unknown browser type! Please check your configuration";
    private BrowserType browserType;
    private boolean isRemoteRun;
    private boolean isHeadLessRun;

    public BrowserFactory(BrowserType browserType, boolean isRemoteRun, boolean isHeadLessRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
        // dodane usunać jak się wyspie
        this.isHeadLessRun = isHeadLessRun;
    }

//    public WebDriver getBrowser() {
//
//        if (isRemoteRun) {
//            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//
//            switch (browserType) {
//                case CHROME:
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    desiredCapabilities.merge(chromeOptions);
//                    return getRemoteWebDriver(desiredCapabilities);
//                case FIREFOX:
//                    FirefoxOptions firefoxOptions = new FirefoxOptions();
//                    desiredCapabilities.merge(firefoxOptions);
//                    return getRemoteWebDriver(desiredCapabilities);
//                default:
//                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
//            }
//        } else {
//            switch (browserType) {
//                case CHROME:
//                    System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
//                    return new ChromeDriver();
//                case FIREFOX:
//                    System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
//                    return new FirefoxDriver();
//                default:
//                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
//            }
//        }
//    }


    public WebDriver getBrowser() {

        if (isRemoteRun) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge(firefoxOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        } else {
            if (isHeadLessRun) {
                switch (browserType) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                        ChromeOptions options = new ChromeOptions();
                        options.setHeadless(true);
                        options.addArguments("--no-sandbox");
                        return new ChromeDriver(options);
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                        FirefoxOptions option = new FirefoxOptions();
                        option.setHeadless(true);
                        option.addArguments("--no-sandbox");
                        return new FirefoxDriver(option);
                    default:
                        throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
                }
            } else {
                switch (browserType) {
                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", LocalWebDriverProperties.getChromeWebDriverLocation());
                        return new ChromeDriver();
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxWebDriverLocation());
                        return new FirefoxDriver();
                    default:
                        throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
                }
            }
        }
    }


    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;
        try{
            remoteWebDriver = new RemoteWebDriver(new URL(TestRunProperties.getGridUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: " + e.getMessage());
        }
        return remoteWebDriver;
    }


}

