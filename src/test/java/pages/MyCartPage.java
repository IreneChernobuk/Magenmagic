package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyCartPage {
    private static final Logger LOGGER = LogManager.getLogger(MyCartPage.class.getName());
    private SelenideElement GOTOCHECKOUTBUTTON = $(By.cssSelector("[data-role = 'proceed-to-checkout']"));
    private static final String OPTION_XPATH = "//tbody[contains(.,'%s')]//a[@title='Remove']";
    private static final String TITLE_XPATH = "//tbody[contains(.,'%s')]";

    @Step("Click 'Go To Checkout' button")
    public void clickGoToCheckoutButton() {
        LOGGER.debug(String.format("Attempt to click element: %s", GOTOCHECKOUTBUTTON));
        GOTOCHECKOUTBUTTON.scrollTo().click();
    }

    @Step("Delete Extension from 'My Cart'")
    public void clickCrossIcon(String titleExtension) {
        String optionFinalXpath = String.format(OPTION_XPATH, titleExtension);
        LOGGER.info("Attempt to delete product");
        $(By.xpath(optionFinalXpath)).shouldBe(Condition.visible).scrollTo().click();
    }

    @Step("Check Cart after remove")
    public boolean checkCartAfterRemove(String titleExtension) {
        String TitleFinalXpath = String.format(TITLE_XPATH, titleExtension);
        LOGGER.info("Check the 'My Cart' after deleting product");
        return $(By.xpath(TitleFinalXpath)).exists();
    }
}