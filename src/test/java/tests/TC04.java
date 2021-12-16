package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public final class TC04 extends BaseTest {

    @Test()
    public void clearItemsInCart() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.clickAddToCart("1")
                .waitForCartPageToLoad()
                .clickAddedItemRemoveButton("1")
                .waitForNoItemsInCartMessageToLoad();

        int cartTotalPriceText = cartPage.getCartTotalPriceText();
        int bagQuantityCountText = cartPage.getBagQuantityCountText();

        Assert.assertEquals(0,cartTotalPriceText);
        Assert.assertEquals(0,bagQuantityCountText);
    }
}