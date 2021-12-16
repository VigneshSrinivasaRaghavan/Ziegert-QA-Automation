package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public final class TC05 extends BaseTest {

    @Test()
    public void increaseItemQuantityInCartPage() {
        HomePage homePage = new HomePage();
        int itemPrice = homePage.getItemPrice("1");
        CartPage cartPage = homePage.clickAddToCart("1")
                .waitForCartPageToLoad()
                .clickIncreaseQuantity()
                .clickIncreaseQuantity();
        
        int cartTotalPriceText = cartPage.getCartTotalPriceText();
        int bagQuantityCountText = cartPage.getBagQuantityCountText();

        Assert.assertEquals(itemPrice*3,cartTotalPriceText);
        Assert.assertEquals(3,bagQuantityCountText);
    }
}