package pom.fish;

import io.qameta.allure.Step;
import logger.LoggerManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

import java.util.List;

public class FishPage {


    @FindAll({
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-SW-01']"),
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-SW-02']"),
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-FW-01']"),
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Catalog.action?viewProduct=&productId=FI-FW-02']")
    })
    private List<WebElement> fishFromTable;

    private LoggerManager loggerManager = new LoggerManager(FishPage.class);

    public List<WebElement> getFishFromTable() {
        return fishFromTable;
    }


    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("On the page with fish list user clicks on the Angel fish button")
    public AngelFishList chooseAngelfishFromTable() {
        WaitForElement.waitUntilElementIsClickable(getFishFromTable().get(0));
        getFishFromTable().get(0).click();
        loggerManager.getLoggerInfo("User click on the angle fish button");
        return new AngelFishList();
    }



}
