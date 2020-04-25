package generic.assertions;

import logger.LoggerManager;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;


public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {


    LoggerManager loggerManager = new LoggerManager(AssertWebElement.class);

    public AssertWebElement(WebElement webElement) {
        super(webElement, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement){
        return new AssertWebElement(webElement);
    }


    public AssertWebElement isDisplayed(){
        loggerManager.getLoggerInfo("Checking if element is displayed");
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Element was not displayed!");
        }
        loggerManager.getLoggerInfo("WebElement was displayed!");
        return this;
    }

    public AssertWebElement hasText(String expectedTextValue){
        loggerManager.getLoggerInfo("Checking if WebElement has text: " + expectedTextValue);
        isNotNull();

        String actualElementText = actual.getText();
        if(!actualElementText.equals(expectedTextValue)){
            failWithMessage("Element text was <%s> expecting to be <%s>!", actualElementText, expectedTextValue);
        }

        loggerManager.getLoggerInfo("WebElement had expected text!");
        return this;
    }

}