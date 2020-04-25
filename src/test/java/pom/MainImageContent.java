package pom;


import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pom.fish.FishPage;
import waits.WaitForElement;

import java.util.List;

public class MainImageContent extends BasePage {


    @FindAll({
            @FindBy(xpath = "//*[@alt='Fish']"),
            @FindBy(xpath = "//*[@alt='Dogs']"),
            @FindBy(xpath = "//*[@alt='Reptiles']"),
            @FindBy(xpath = "//*[@alt='Cats']"),
            @FindBy(xpath = "//*[@alt='Birds']"),
    })
    private List<WebElement> listOfAnimals;

    public List<WebElement> getListOfAnimals() {
        return listOfAnimals;
    }


    @Step("User click on the Fish picture on the main animal pictures")
    public FishPage clickOnTheFishPicture() {
        WaitForElement.waitUntilElementIsClickable(getListOfAnimals().get(0));
        getListOfAnimals().get(0).click();
        log().info("User has clicked on the fish picture in main image.");
        return new FishPage();
    }







}
