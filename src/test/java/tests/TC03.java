package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

/*
 * This test is to check out a product item
 * And also to verify the price post checking out an item
 */

public final class TC03 extends BaseTest {

    @Test()
    public void checkoutItems() {
        HomePage homePage = new HomePage();
        int itemPrice = homePage.getItemPrice("1");
        String productName = homePage.getProductName("1");
        homePage.clickAddToCart("1").waitForCartPageToLoad();
        CartPage cartPage = new CartPage();
        String addedProductNameText = cartPage.getAddedProductNameText();
        int addedProductPriceText = cartPage.getAddedProductPriceText();
        int bagQuantityCountText = cartPage.getBagQuantityCountText();


        Assert.assertEquals(addedProductPriceText,itemPrice,"Price does not match");
        Assert.assertEquals(addedProductNameText,productName,"Product Name does not match");
        Assert.assertEquals(bagQuantityCountText,1,"Quantity does not match");

        cartPage.clickCheckoutButton();
        String alertText = cartPage.getAlertText().replaceAll("[^0-9]", "");
        cartPage.closeAlert();

        Assert.assertEquals(Integer.parseInt(alertText),itemPrice,"Price does not match");
    }
}