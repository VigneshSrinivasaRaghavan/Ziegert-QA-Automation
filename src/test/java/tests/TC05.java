package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

/*
 * This test is to verify if the quantity can be increased directly in the Cart
 * And also to verify if the total price post increasing the quantity
 */

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

        Assert.assertEquals(cartTotalPriceText,itemPrice*3,"Price does not match");
        Assert.assertEquals(bagQuantityCountText,3,"Quantity does not match");
    }
}