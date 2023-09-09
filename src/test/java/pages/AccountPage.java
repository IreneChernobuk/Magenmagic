package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    private static final Logger LOGGER = LogManager.getLogger(AccountPage.class.getName());
    private SelenideElement EMAILINPUT = $(By.id("email"));
    private SelenideElement PASSWORDINPUT = $(By.id("pass"));
    private SelenideElement SIGNINBUTTON = $(By.xpath("//div[@class='login-container']//button[@id='send2']"));
    private SelenideElement PAGETITLE = $(By.cssSelector("[data-ui-id=page-title-wrapper]"));
    private SelenideElement ERRORMESSAGE = $(By.cssSelector("[data-ui-id='message-error']"));

    @Step("Authorization")
    public void logIn(String email, String password) {
        EMAILINPUT.sendKeys(email);
        PASSWORDINPUT.sendKeys(password);
        LOGGER.debug(String.format("Attempt to click element: %s", SIGNINBUTTON));
        SIGNINBUTTON.click();
    }

    @Step("Check that page title message on displayed")
    public boolean isPageTitleDisplayed() {
        LOGGER.info("Check that page title message on displayed");
        return PAGETITLE.shouldHave(Condition.exactText("My Account")).isDisplayed();
    }

    @Step("Check that error message on displayed")
    public boolean isErrorMessageDisplayed() {
        LOGGER.info("Check that error message on displayed");
        return ERRORMESSAGE.shouldBe(Condition.visible).isDisplayed();
    }
}