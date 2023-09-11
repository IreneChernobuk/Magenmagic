package tests;

import constants.Credentials;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ForSalesPage;
import pages.MainPage;
import pages.ProductPage;

@Epic("Smoke")
@Feature("Order")
@Story("View Product Details")
public class ProductTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ProductTest.class.getName());

    @Description("View Product Details")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void viewProductDetailsTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        LOGGER.info(String.format("Page %s opened", AccountPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        accountPage.logIn(Credentials.USEREMAIL, Credentials.PASSWORD);
        mainPage.clickExtensForSalesElement();
        ForSalesPage forSalesPage = new ForSalesPage();
        LOGGER.info(String.format("Page %s opened", ForSalesPage.class.getName()));
        forSalesPage.clickSeeMoreExtension();
        ProductPage productPage = new ProductPage();
        LOGGER.info(String.format("Page %s opened", ProductPage.class.getName()));
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed(), "Failed to go tj the product page");
    }
}