package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pom.LandingPage;
import pom.LoginPage;
import pom.MainImageContent;
import test.base.TestBase;

public class ProceedToCheckoutTest extends TestBase {


    @Issue("DEFECT-1")
    @TmsLink("ID-3")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to buy a product click in cart proceed to checkout" +
            " by not logged user.")
    public void proceedToCheckoutMustSignOnMessageTest() {

        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink();

        MainImageContent mainImageContent = new MainImageContent();
        mainImageContent
                .clickOnTheFishPicture()
                .chooseAngelfishFromTable()
                .clickOnTheAddToCartButton()
                .clickOnProceedToToCheckoutButton();
        LoginPage loginPage = new LoginPage();
        loginPage
                .assertThatWarningIsDisplayed(loginPage.getMESSAGEABOUTLOGINFIRST());


    }

}
