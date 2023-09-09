package tests;

import constants.Credentials;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AllExtensionsPage;
import pages.MainPage;

public class CartTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(CartTest.class.getName());

    @Test
    public void addProductMyCart() {
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        accountPage.logIn(Credentials.USEREMAIL, Credentials.PASSWORD);
        mainPage.clickAllExtensionsElement();
        int NumberOfOrders = mainPage.getNumberOfOrders() + 1;
        AllExtensionsPage allExtensPage = new AllExtensionsPage();
        allExtensPage.addToCartExtension();
        Assert.assertEquals(mainPage.getNumberOfOrders(), NumberOfOrders, "product didn't add");
    }
}