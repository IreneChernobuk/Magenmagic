package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private static final Logger LOGGER = LogManager.getLogger(ProductPage.class.getName());
    private SelenideElement ADDTOCARTBUTTON = $(By.id("product-addtocart-button"));

    @Step("Check that 'Add to Cart' button on displayed")
    public boolean isAddToCartButtonDisplayed() {
        LOGGER.debug(String.format("Check that button %s on displayed", ADDTOCARTBUTTON));
        return ADDTOCARTBUTTON.isDisplayed();
    }
}