package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public final class TC02 extends BaseTest {

    @Test()
    public void sortLowestToHighest() {
        HomePage homePage = new HomePage();
        homePage.selectOrderByDropDown("lowestprice");
        int firstItemPrice = homePage.getItemPrice("1");
        int secondItemPrice = homePage.getItemPrice("2");
        Assert.assertTrue(firstItemPrice<secondItemPrice);
    }

    @Test()
    public void sortHighestToLowest() {
        HomePage homePage = new HomePage();
        homePage.selectOrderByDropDown("highestprice");
        int firstItemPrice = homePage.getItemPrice("1");
        int secondItemPrice = homePage.getItemPrice("2");
        Assert.assertTrue(firstItemPrice>secondItemPrice);
    }
}