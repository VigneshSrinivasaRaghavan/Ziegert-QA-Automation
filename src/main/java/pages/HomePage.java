package pages;

import driver.Driver;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class HomePage extends BasePage {

    private static By totalProductsFound = By.cssSelector(".products-found>span");
    private static By productItem = By.cssSelector(".shelf-item");
    private static By sizesButton(String size) {
        String locatorText = "//span[text()='"+size+"']";
        return By.xpath(locatorText);
    }
    private static By spinnerIcon = By.cssSelector(".spinner");
    private static By orderByDropdown = By.cssSelector(".sort>select");
    private static By itemPriceByItem(String itemNumber) {
        String locatorText = "(//div[@class='shelf-item__price']//div[@class='val'])["+itemNumber+"]";
        return By.xpath(locatorText);
    }
    
    public void waitForItemsToLoad(){
        waitForElementToLoad(productItem,WaitStrategy.VISIBLE);
    }

    public int getTotalProductCountText(){
        waitForItemsToLoad();
        return getTextOnlyNumber(totalProductsFound,WaitStrategy.VISIBLE);
    }

    public void selectSize(String sizeValue){
        boolean selected = DriverManager.getDriver().findElement(sizesButton(sizeValue)).findElement(By.xpath("./preceding-sibling::input")).isSelected();
        if(!selected){
        click(sizesButton(sizeValue),WaitStrategy.CLICKABLE,sizeValue+" Size");
        waitForSpinnerToDisappear();
        waitForItemsToLoad();}
        else{
            System.out.println("Already "+sizeValue+" is selected");
        }
    }

    public void unselectSize(String sizeValue){
        boolean selected = DriverManager.getDriver().findElement(sizesButton(sizeValue)).findElement(By.xpath("./preceding-sibling::input")).isSelected();
        if(selected){
            click(sizesButton(sizeValue),WaitStrategy.CLICKABLE,sizeValue+" Size");
            waitForSpinnerToDisappear();
            waitForItemsToLoad();}
        else{
            System.out.println("Already "+sizeValue+" is un-selected");
        }
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

    public void selectOrderByDropDown(String value){
        selectDropDownUsingValue(orderByDropdown,WaitStrategy.VISIBLE,value);
        waitForSpinnerToDisappear();
    }

    public int getItemPrice(String itemNumber){
        return getTextOnlyNumber(itemPriceByItem(itemNumber),WaitStrategy.VISIBLE);
    }
    

}
