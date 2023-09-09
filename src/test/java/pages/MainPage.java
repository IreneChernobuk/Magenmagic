package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class.getName());
    private SelenideElement ACCOUNTELEMENT = $(By.cssSelector(".account"));
    private SelenideElement ALLEXTENSIONSELEMENT = $(By.cssSelector(".magento-extensions"));
    private SelenideElement MYCARTELEMENT = $(By.xpath("//a[contains(.,'My Cart')]"));
    private SelenideElement EXTENSFORSALESELEMENT = $(By.xpath("//a[contains(.,'Extensions for Sales')]"));
    private SelenideElement COUNTERITEMS = $(By.className("counter-number"));
    private SelenideElement SEARCH = $(By.id("search"));
    private SelenideElement ITEMSHELPWORD = $(new ByText("items"));

    @Step("Open homepage")
    public void openMainPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.URL_HOMEPAGE));
        open(Urls.URL_HOMEPAGE);
    }

    @Step("Click 'Account' element")
    public void clickAccountElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", ACCOUNTELEMENT));
        ACCOUNTELEMENT.click();
    }

    @Step("Click 'All Extensions' element")
    public void clickAllExtensionsElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", ALLEXTENSIONSELEMENT));
        ALLEXTENSIONSELEMENT.click();
    }

    @Step("Click 'Extensions for Sales' element")
    public void clickExtensForSalesElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", EXTENSFORSALESELEMENT));
        EXTENSFORSALESELEMENT.click();
    }

    @Step("Click 'My Cart' element")
    public void clickMyCartElement() {
        LOGGER.debug(String.format("Attempt to click element: %s", MYCARTELEMENT));
        MYCARTELEMENT.click();
    }

    @Step("Getting the number of items in the cart")
    public int getNumberOfOrders() {
        ITEMSHELPWORD.shouldBe(Condition.visible);
        LOGGER.debug(String.format("Recieve number of orders: %s", Integer.valueOf(COUNTERITEMS.getText())));
        return Integer.valueOf(COUNTERITEMS.getText());
    }
    @Step("Search by product title")
    public void inputSearchField(String title) {
        SEARCH.sendKeys(title);
        SEARCH.submit();
    }
}