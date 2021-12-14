package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class HomePage extends BasePage {

    private static By totalProductsFound = By.cssSelector(".products-found>span");
    private static By productItem = By.cssSelector(".shelf-item");
    private By sizesButton(String size) {
        String locatorText = "//span[text()='"+size+"']";
        return By.xpath(locatorText);
    }
    private static By spinnerIcon = By.cssSelector(".spinner");

    public void waitForItemsToLoad(){
        waitForElementToLoad(productItem,WaitStrategy.VISIBLE);
    }

    public String getTotalProductCountText(){
        waitForItemsToLoad();
        return getTextOnlyNumber(totalProductsFound,WaitStrategy.VISIBLE);
    }

    public void clickSizeButton(String sizeValue){
        click(sizesButton(sizeValue),WaitStrategy.CLICKABLE,sizeValue+" Size");
        waitForSpinnerToDisappear();
        waitForItemsToLoad();
    }

    public void waitForSpinnerToDisappear(){
        List<WebElement> element = DriverManager.getDriver().findElements(spinnerIcon);
        int count = 0;
        while (element.size()!=0 && count<5){
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
