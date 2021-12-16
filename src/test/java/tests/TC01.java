package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public final class TC01 extends BaseTest {

    @Test()
    public void verifyProductsFoundCount(){
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getTotalProductCountText(),16,"Product Count does not match");

        homePage.selectSize("XS");
        Assert.assertEquals(homePage.getTotalProductCountText(),1,"Product Count does not match");
        homePage.unselectSize("XS");

        homePage.selectSize("S");
        Assert.assertEquals(homePage.getTotalProductCountText(),2,"Product Count does not match");
        homePage.unselectSize("S");

        homePage.selectSize("M");
        Assert.assertEquals(homePage.getTotalProductCountText(),1,"Product Count does not match");
        homePage.unselectSize("M");
    }
}