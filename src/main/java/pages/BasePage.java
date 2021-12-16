package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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

    protected int getTextOnlyNumber(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        String text = DriverManager.getDriver().findElement(by).getText().replaceAll("[^0-9]", "");
        return Integer.parseInt(text);
    }

    protected void waitForElementToLoad(By by,WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
    }

    protected void selectDropDownUsingValue(By by,WaitStrategy waitStrategy,String valueText){
        ExplicitWaitFactory.performExplicitWait(by,waitStrategy);
        Select select = new Select(DriverManager.getDriver().findElement(by));
        select.selectByValue(valueText);
    }

    public String getAlertText(){
        Alert alert = DriverManager.getDriver().switchTo().alert();
        return alert.getText();
    }

    public void closeAlert(){
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();
    }
}
