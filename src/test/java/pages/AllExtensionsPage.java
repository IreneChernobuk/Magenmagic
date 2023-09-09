package pages;

import com.codeborne.selenide.ElementsCollection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import utils.FakerMessageGenerator;

import static com.codeborne.selenide.Selenide.$$;

public class AllExtensionsPage {
    private static final Logger LOGGER = LogManager.getLogger(AllExtensionsPage.class.getName());
    private ElementsCollection PRODUCTIMAGE = $$(By.cssSelector(".product-item-inner"));
    private ElementsCollection ADDTOCARTICON = $$(By.cssSelector("[title = 'Add to Cart']"));

    public void addToCartExtension() {
        int i = FakerMessageGenerator.generateNumberItem();
        LOGGER.debug(String.format("Attempt to hover element: %s", PRODUCTIMAGE));
        PRODUCTIMAGE.get(i).hover();
        LOGGER.debug(String.format("Attempt to click element: %s", ADDTOCARTICON));
        ADDTOCARTICON.get(i).click();
    }
}