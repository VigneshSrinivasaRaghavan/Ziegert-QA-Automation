package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public final class TC02 extends BaseTest {

    @Test()
    public void verifyProductsFoundCount() throws InterruptedException {
        HomePage homePage = new HomePage();
        String totalProductCountText = homePage.getTotalProductCountText();
        Assert.assertEquals(16,Integer.parseUnsignedInt(totalProductCountText));

        homePage.clickSizeButton("XS");
        String totalProductCountText2 = homePage.getTotalProductCountText();
        Assert.assertEquals(1,Integer.parseUnsignedInt(totalProductCountText2));
        homePage.clickSizeButton("XS");

        homePage.clickSizeButton("S");
        String totalProductCountText3 = homePage.getTotalProductCountText();
        Assert.assertEquals(2,Integer.parseUnsignedInt(totalProductCountText3));
        homePage.clickSizeButton("S");

        homePage.clickSizeButton("M");
        String totalProductCountText4 = homePage.getTotalProductCountText();
        Assert.assertEquals(1,Integer.parseUnsignedInt(totalProductCountText4));
        homePage.clickSizeButton("M");
    }
}