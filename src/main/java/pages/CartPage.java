package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CartPage extends BasePage {

    private static By cartPanel = By.cssSelector(".float-cart__content");
    private static By cartTotalPrice = By.cssSelector(".sub-price__val");
    private static By checkoutButton = By.cssSelector(".buy-btn");
    private static By bagQuantity = By.cssSelector(".bag__quantity");
    private static By noItemsInCartMessage = By.cssSelector(".shelf-empty");
    private static By increaseQuantity = By.cssSelector(".change-product-button:nth-child(2)");
    private static By addedProductName(String itemNumber) {
        String locatorText = "(//div[@class='shelf-item__details']//p[@class='title'])["+itemNumber+"]";
        return By.xpath(locatorText);
    }
    private static By addedProductPrice(String itemNumber) {
        String locatorText = "(//div[@class='shelf-item__price']//p)["+itemNumber+"]";
        return By.xpath(locatorText);
    }
    private static By addedItemRemoveButton(String itemNumber) {
        String locatorText = "(//div[@class='shelf-item__del'])["+itemNumber+"]";
        return By.xpath(locatorText);
    }

    public CartPage waitForCartPageToLoad(){
        waitForElementToLoad(cartPanel,WaitStrategy.VISIBLE);
        return this;
    }

    public String getAddedProductNameText(String itemNumber){
        return getText(addedProductName(itemNumber),WaitStrategy.VISIBLE);
    }

    public int getAddedProductPriceText(String itemNumber){
        return getTextOnlyNumber(addedProductPrice(itemNumber),WaitStrategy.VISIBLE);
    }

    public int getCartTotalPriceText(){
        return getTextOnlyNumber(cartTotalPrice,WaitStrategy.VISIBLE);
    }

    public void clickCheckoutButton(){
        click(checkoutButton,WaitStrategy.CLICKABLE,"Check Out Button");
    }

    public int getBagQuantityCountText(){
        return getTextOnlyNumber(bagQuantity,WaitStrategy.VISIBLE);
    }

    public CartPage clickAddedItemRemoveButton(String itemNumber){
        click(addedItemRemoveButton(itemNumber),WaitStrategy.CLICKABLE,"Item Remove Button");
        return this;
    }

    public CartPage waitForNoItemsInCartMessageToLoad(){
        waitForElementToLoad(noItemsInCartMessage,WaitStrategy.VISIBLE);
        return this;
    }

    public CartPage clickIncreaseQuantity(){
        click(increaseQuantity,WaitStrategy.CLICKABLE,"Increase Quantity Button");
        return this;
    }

}
