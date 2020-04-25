package pom;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;


public class LoginPage extends BasePage {


    @FindBy(name = "username")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(name = "signon")
    private WebElement signOnButton;
    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;



    private final String INVALIDUSERNAME = "hello world";
    private final String INVALIDPASSWORD = "hello world";
    private final String EXPECTEDMESSAGE = "Invalid username or password. Signon failed.";
    private final String VALIDUSERNAME = "j2ee";
    private final String VALIDPASSWORD = "j2ee";
    private final String MESSAGEABOUTLOGINFIRST = "You must sign on before attempting to check out. Please sign on and try checking out again.";


    public String getEXPECTEDMESSAGE() {
        return EXPECTEDMESSAGE;
    }
    public String getINVALIDUSERNAME() {
        return INVALIDUSERNAME;
    }
    public String getINVALIDPASSWORD(){
        return INVALIDPASSWORD;
    }
    public String getVALIDUSERNAME() {
        return VALIDUSERNAME;
    }
    public String getVALIDPASSWORD() {
        return VALIDPASSWORD;
    }
    public String getMESSAGEABOUTLOGINFIRST(){
        return MESSAGEABOUTLOGINFIRST;
    }


    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        usernameField.clear();
        log().info("User has clear field username. ");
        usernameField.sendKeys(username);
        log().info("User has enter " + username + " in field username.");
        return this;

    }

    @Step("Type into Password Field {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        log().info("User has clear field password");
        passwordField.sendKeys(password);
        log().info("User has enter " + password + " in password field.");
        return this;
    }

    @Step("Click on the Login Button")
    public MainImageContent clickOnLoginButton() {
        WaitForElement.waitUntilElementIsClickable(signOnButton);
        signOnButton.click();
        log().info("User clicked on the sign on button");
        return new MainImageContent();
    }

    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        //log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

}
