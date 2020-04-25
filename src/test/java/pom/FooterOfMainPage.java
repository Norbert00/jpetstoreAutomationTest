package pom;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterOfMainPage extends BasePage {


    @FindBy(css = "#Banner > img")
    private WebElement pictureOfDog;


    @Step("Assert that element dog banner is displayed")
    public FooterOfMainPage assertThatDogBannerIsDisplayed() {
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(pictureOfDog);
        assertThat(pictureOfDog).isDisplayed();
        return this;
    }

}
