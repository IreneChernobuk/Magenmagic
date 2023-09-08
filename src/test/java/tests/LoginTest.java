package tests;

import constants.Credentials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;
import utils.FakerMessageGenerator;

public class LoginTest extends BaseTest{

    @Test
    public void loginValidDataTest(){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        accountPage.logIn(Credentials.USERNAME, Credentials.PASSWORD);
        Assert.assertTrue(accountPage.isPageTitleDisplayed(), "Login failed");
    }

    @Test
    public void loginInvalidDataTest(){
        MainPage mainPage = new MainPage();
        mainPage.openMainPage();
        mainPage.clickAccountElement();
        AccountPage accountPage = new AccountPage();
        accountPage.logIn(FakerMessageGenerator.generateEmail(), FakerMessageGenerator.generatePassword());
        Assert.assertTrue(accountPage.isErrorMessageDisplayed(), "User is logged in");
    }
}