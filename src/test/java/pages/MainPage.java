package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import constants.Urls;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement AccountElement = $(By.cssSelector(".account"));
    private SelenideElement AllExtensionsElement = $(By.cssSelector(".magento-extensions"));
    private SelenideElement CountItems = $(By.className("counter-number"));
    private SelenideElement ItemsHelpWord = $(new ByText("items"));

    public void openMainPage() {
        open(Urls.URL_HOMEPAGE);
    }

    public void clickAccountElement() {
        AccountElement.click();
    }

    public void clickAllExtensionsElement() {
        AllExtensionsElement.click();
    }

    public int getNumberOfOrders() {
        ItemsHelpWord.shouldBe(Condition.visible);
        return Integer.valueOf(CountItems.getText());
    }
}