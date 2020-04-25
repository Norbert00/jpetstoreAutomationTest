package pom;

import driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public abstract class BasePage {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    protected Logger log() {
        return logger;
    }

}
