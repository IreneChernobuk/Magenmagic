package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.FakerMessageGenerator;

import static com.codeborne.selenide.Selenide.$$;

public class AllExtensionsPage {
    int i;
    private static final Logger LOGGER = LogManager.getLogger(AllExtensionsPage.class.getName());
    private ElementsCollection PRODUCTIMAGE = $$(By.cssSelector(".product-item-inner"));
    private ElementsCollection ADDTOCARTICON = $$(By.cssSelector("[title = 'Add to Cart']"));
    private ElementsCollection NAMEEXTENSION = $$(By.className("product-item-link"));

    @Step("Adding Extension to the 'My Cart'")
    public void addToCartExtension() {
        NAMEEXTENSION.get(i).getText();
        LOGGER.debug(String.format("Attempt to hover element: %s", PRODUCTIMAGE));
        PRODUCTIMAGE.get(i).scrollTo().hover();
        LOGGER.debug(String.format("Attempt to click element: %s", ADDTOCARTICON));
        ADDTOCARTICON.get(i).click();
    }

    @Step("Receiving Extension title")
    public String getTitleExtension() {
        i = FakerMessageGenerator.generateNumberItem();
        LOGGER.debug(String.format("Get title extension %s", NAMEEXTENSION.get(i).getText()));
        return NAMEEXTENSION.get(i).getText();
    }
}