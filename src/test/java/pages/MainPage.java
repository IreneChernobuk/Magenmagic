package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());
    private SelenideElement ACCOUNTELEMENT = $(By.cssSelector(".account"));
    private SelenideElement ALLEXTENSIONSELEMENT = $(By.cssSelector(".magento-extensions"));
    private SelenideElement COUNTERITEMS = $(By.className("counter-number"));
    private SelenideElement ITEMSHELPWORD = $(new ByText("items"));

    public void openMainPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.URL_HOMEPAGE));
        open(Urls.URL_HOMEPAGE);
    }

    public void clickAccountElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", ACCOUNTELEMENT));
        ACCOUNTELEMENT.click();
    }

    public void clickAllExtensionsElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", ALLEXTENSIONSELEMENT));
        ALLEXTENSIONSELEMENT.click();
    }

    public int getNumberOfOrders() {
        ITEMSHELPWORD.shouldBe(Condition.visible);
        LOGGER.debug(String.format("Recieve number of orders: %s", Integer.valueOf(COUNTERITEMS.getText())));
        return Integer.valueOf(COUNTERITEMS.getText());
    }
}