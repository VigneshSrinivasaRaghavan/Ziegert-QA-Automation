package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public final class CartPage extends BasePage {

    private static final By cartPanel = By.cssSelector(".float-cart__content");
    private static final By cartTotalPrice = By.cssSelector(".sub-price__val");
    private static final By checkoutButton = By.cssSelector(".buy-btn");
    private static final By bagQuantity = By.cssSelector(".bag__quantity");
    private static final By noItemsInCartMessage = By.cssSelector(".shelf-empty");
    private static final By increaseQuantity = By.cssSelector(".change-product-button:nth-child(2)");
    private static final By addedProductName = By.cssSelector(".shelf-item__details>p:nth-child(1)");
    private static final By addedProductPrice = By.cssSelector(".shelf-item__price>p:nth-child(1)");
    private static final By addedItemRemoveButton = By.cssSelector(".shelf-item__del");

    public CartPage waitForCartPageToLoad(){
        waitForElementToLoad(cartPanel,WaitStrategy.VISIBLE);
        return this;
    }

    public String getAddedProductNameText(){
        return getText(addedProductName,WaitStrategy.VISIBLE);
    }

    public int getAddedProductPriceText(){
        return getTextOnlyNumber(addedProductPrice,WaitStrategy.VISIBLE);
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

    public CartPage clickAddedItemRemoveButton(){
        click(addedItemRemoveButton,WaitStrategy.CLICKABLE,"Item Remove Button");
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
