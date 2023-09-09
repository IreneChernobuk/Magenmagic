package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    private static final Logger LOGGER = LogManager.getLogger(CheckoutPage.class.getName());
    private SelenideElement PLACEORDERBUTTON = $(By.cssSelector("[title ='Place Order']"));

    @Step("Check that 'Place Order' button on displayed")
    public boolean isPlaceOrderButtonDisplayed() {
        LOGGER.debug(String.format("Check that button: %s on displayed", PLACEORDERBUTTON));
        return PLACEORDERBUTTON.scrollTo().isDisplayed();
    }
}