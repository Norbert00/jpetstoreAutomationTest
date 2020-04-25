package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class CheckoutPage extends BasePage {


    @FindBy(xpath = "//*[@href='/jpetstore/actions/Cart.action?removeItemFromCart=&cartItem=EST-1']")
    private WebElement removeButton;
    @FindBy(xpath = "//*[@href='/jpetstore/actions/Order.action?newOrderForm=']")
    private WebElement proceedToCheckoutButton;



    @Step("User in the cart page clicks on the checkout button")
    public LoginPage clickOnProceedToToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("User has clicked on the proceed to checkout button.");
        return new LoginPage();
    }





}
