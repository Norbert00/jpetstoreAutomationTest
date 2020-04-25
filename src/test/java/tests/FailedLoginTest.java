package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pom.LoginPage;
import test.base.TestBase;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTest extends TestBase {


    private static final String EXPECTEDTEXT = "Invalid username or password. Signon failed.";

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField(loginPage.getINVALIDUSERNAME())
                .typeIntoPasswordField(loginPage.getINVALIDPASSWORD())
                .clickOnLoginButton();
        loginPage
                .assertThatWarningIsDisplayed(loginPage.getEXPECTEDMESSAGE());

    }

}
