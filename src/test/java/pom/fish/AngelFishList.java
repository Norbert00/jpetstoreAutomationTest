package pom.fish;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import logger.LoggerManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.CheckoutPage;
import waits.WaitForElement;

import java.util.List;

public class AngelFishList {

    @FindAll({
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-1']"),
            @FindBy(xpath = "//*[@href='/jpetstore/actions/Cart.action?addItemToCart=&workingItemId=EST-2']")
    })
    private List<WebElement> buttonsAddToCart;
    public List<WebElement> getButtonsAddToCart() {
        return buttonsAddToCart;
    }

    private LoggerManager loggerManager = new LoggerManager(AngelFishList.class);

    public AngelFishList() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }


    @Step("In the table with angel fish user clicks add to the cart button choosing small fish.")
    public CheckoutPage clickOnTheAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(getButtonsAddToCart().get(0));
        getButtonsAddToCart().get(0).click();
        loggerManager.getLoggerInfo("Click on the add to cart button.");

        return new CheckoutPage();
    }

}


