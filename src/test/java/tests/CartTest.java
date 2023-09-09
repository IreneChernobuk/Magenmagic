package tests;

import com.codeborne.selenide.Selenide;
import constants.Credentials;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.AllExtensionsPage;
import pages.MainPage;
import pages.MyCartPage;

@Epic("Smoke")
@Feature("Cart")
@Story("Creating and deleting order")
public class CartTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CartTest.class.getName());
    String titleExtension;

    @Description("Adding new product in the 'My Cart'")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void addProductMyCartTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        LOGGER.info(String.format("Page %s opened", AccountPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        accountPage.logIn(Credentials.USEREMAIL, Credentials.PASSWORD);
        mainPage.clickAllExtensionsElement();
        LOGGER.info("Getting the number of items in the cart");
        int NumberOfOrders = mainPage.getNumberOfOrders() + 1;
        LOGGER.info(String.format("Getting the number of items in the cart after adding %d", NumberOfOrders));
        AllExtensionsPage allExtensPage = new AllExtensionsPage();
        LOGGER.info(String.format("Page %s opened", AllExtensionsPage.class.getName()));
        titleExtension = allExtensPage.getTitleExtension();
        LOGGER.info(String.format("received extension title: '%s'", titleExtension));
        allExtensPage.addToCartExtension();
        Assert.assertEquals(mainPage.getNumberOfOrders(), NumberOfOrders, "product didn't add");
        Selenide.clearBrowserCookies();
    }

    @Description("Deleting order in the 'My Cart'")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = "addProductMyCartTest")
    public void deleteProductMyCartTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        LOGGER.info(String.format("Page %s opened", AccountPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        accountPage.logIn(Credentials.USEREMAIL, Credentials.PASSWORD);
        mainPage.clickMyCartElement();
        MyCartPage myCartPage = new MyCartPage();
        LOGGER.info(String.format("Page %s opened", MyCartPage.class.getName()));
        myCartPage.clickCrossIcon(titleExtension);
        LOGGER.info("Extension was removed");
        Assert.assertFalse(myCartPage.checkCartAfterRemove(titleExtension), "Extension was not deleted");
        LOGGER.info("There isn't relevant extension 'My Cart'");
        Selenide.clearBrowserCookies();
    }
}