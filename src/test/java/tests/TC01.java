package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public final class TC01 extends BaseTest {

    @Test()
    public void verifyProductsFoundCount(){
        HomePage homePage = new HomePage();
        Assert.assertEquals(16,homePage.getTotalProductCountText());

        homePage.selectSize("XS");
        Assert.assertEquals(1,homePage.getTotalProductCountText());
        homePage.unselectSize("XS");

        homePage.selectSize("S");
        Assert.assertEquals(2,homePage.getTotalProductCountText());
        homePage.unselectSize("S");

        homePage.selectSize("M");
        Assert.assertEquals(1,homePage.getTotalProductCountText());
        homePage.unselectSize("M");
    }
}