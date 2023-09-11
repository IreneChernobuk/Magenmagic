package tests;

import constants.Credentials;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CheckoutPage;
import pages.MainPage;
import pages.MyCartPage;

@Epic("Smoke")
@Feature("Payment")
@Story("'Go To Checkout'")
public class PaymentTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(PaymentTest.class.getName());

    @Description("Transition to payment via 'Go To Checkout'")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void goToCheckoutTest() {
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
        myCartPage.clickGoToCheckoutButton();
        CheckoutPage checkoutPage = new CheckoutPage();
        LOGGER.info(String.format("Page %s opened", MyCartPage.class.getName()));
        Assert.assertTrue(checkoutPage.isPlaceOrderButtonDisplayed(), "There is no way to make payment");
    }
}