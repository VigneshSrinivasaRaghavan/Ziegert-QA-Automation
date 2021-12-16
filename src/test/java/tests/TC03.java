package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

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


        Assert.assertEquals(itemPrice,addedProductPriceText);
        Assert.assertEquals(productName,addedProductNameText);
        Assert.assertEquals(1,bagQuantityCountText);

        cartPage.clickCheckoutButton();
        String alertText = cartPage.getAlertText().replaceAll("[^0-9]", "");
        cartPage.closeAlert();

        Assert.assertEquals(itemPrice,Integer.parseInt(alertText));
    }
}