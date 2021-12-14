package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public final class TC01 extends BaseTest {

    @Test()
    public void verifyProductsFoundCount(){
        HomePage homePage = new HomePage();
        Assert.assertEquals(16,homePage.getTotalProductCountText());

        homePage.clickSizeButton("XS");
        Assert.assertEquals(1,homePage.getTotalProductCountText());
        homePage.clickSizeButton("XS");

        homePage.clickSizeButton("S");
        Assert.assertEquals(2,homePage.getTotalProductCountText());
        homePage.clickSizeButton("S");

        homePage.clickSizeButton("M");
        Assert.assertEquals(1,homePage.getTotalProductCountText());
        homePage.clickSizeButton("M");
    }
}