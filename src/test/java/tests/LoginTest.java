package tests;

import constants.Credentials;
import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import utils.FakerMessageGenerator;

@Epic("Smoke")
@Feature("Login")
@Story("Login registered user")
public class LoginTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Description("Log in registered user with valid data")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void loginValidDataTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        LOGGER.info(String.format("Page %s opened", AccountPage.class.getName()));
        LOGGER.info("Input EMAIL and PASSWORD");
        accountPage.logIn(Credentials.USEREMAIL, Credentials.PASSWORD);
        Assert.assertTrue(accountPage.isPageTitleDisplayed(), "Login failed");
        LOGGER.info("Login completed successfully");
    }

    @Description("Log in registered user with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginInvalidDataTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        LOGGER.info(String.format("Page %s opened", AccountPage.class.getName()));
        accountPage.logIn(FakerMessageGenerator.generateEmail(), FakerMessageGenerator.generatePassword());
        LOGGER.info("Input invalid EMAIL and PASSWORD");
        Assert.assertTrue(accountPage.isErrorMessageDisplayed(), "User is logged in");
        LOGGER.info("Login completed unsuccessfully");
    }
}