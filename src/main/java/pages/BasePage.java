package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import reports.ExtentLogger;

public class BasePage {

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy).sendKeys(value);
        ExtentLogger.pass(value +" is entered in the "+elementName);
    }

    protected void click(By by,WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy).click();
        ExtentLogger.pass(elementName +" is clicked");
    }

    protected String getText(By by,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        return DriverManager.getDriver().findElement(by).getText();
    }

    protected String getTextOnlyNumber(By by,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        return DriverManager.getDriver().findElement(by).getText().replaceAll("[^0-9]", "");
    }

    protected void waitForElementToLoad(By by,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
    }
}
