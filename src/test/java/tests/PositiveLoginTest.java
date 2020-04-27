package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pom.FooterPage;
import pom.LoginPage;
import test.base.TestBase;

import static navigation.ApplicationURLs.LOGIN_URL;

public class PositiveLoginTest extends TestBase {

    @Issue("DEFECT-2")
    @TmsLink("ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton();
        FooterPage footerPage = new FooterPage();
        footerPage
                .assertThatDogBannerIsDisplayed();
    }




}
