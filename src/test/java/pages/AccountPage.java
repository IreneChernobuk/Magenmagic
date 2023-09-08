package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {
    private SelenideElement EmailInput = $(By.id("email"));
    private SelenideElement PasswordInput = $(By.id("pass"));
    private SelenideElement SingInButton = $(By.xpath("//div[@class = 'login-container']//button[@id = 'send2']"));
    private SelenideElement PageTitle = $(By.cssSelector("[data-ui-id=page-title-wrapper]"));
    private SelenideElement ErrorMessage = $(By.cssSelector("[data-ui-id = 'message-error']"));

    public void logIn(String email, String password) {
        EmailInput.sendKeys(email);
        PasswordInput.sendKeys(password);
        SingInButton.click();
    }

    public boolean isPageTitleDisplayed() {
        return PageTitle.shouldHave(Condition.exactText("My Account")).isDisplayed();
    }

    public boolean isErrorMessageDisplayed (){
        return ErrorMessage.shouldBe(Condition.visible).isDisplayed();
    }
}