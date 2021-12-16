package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public final class TC06 extends BaseTest {

    @Test()
    public void NegativeTestToCheckPriceMismatch() {
        HomePage homePage = new HomePage();
        CartPage cartPage = homePage.clickAddToCart("1")
                .waitForCartPageToLoad();

        int cartTotalPriceText = cartPage.getCartTotalPriceText();
        int bagQuantityCountText = cartPage.getBagQuantityCountText();

        Assert.assertEquals(cartTotalPriceText,0,"Mismatch with the price");
        Assert.assertEquals(bagQuantityCountText,0,"Mismatch with the quantity");
    }
}