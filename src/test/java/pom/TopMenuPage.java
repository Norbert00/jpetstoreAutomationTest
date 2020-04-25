package pom;


import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class TopMenuPage extends BasePage {


    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;


    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("User click on sign on button.");
        return new LoginPage();
    }


}
