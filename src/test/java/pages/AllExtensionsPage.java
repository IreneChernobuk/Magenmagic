package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.FakerMessageGenerator;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AllExtensionsPage {

    private ElementsCollection ProductImage = $$(By.cssSelector(".product-item-inner"));
    private ElementsCollection AddToCartIcon = $$(By.cssSelector("[title = 'Add to Cart']"));

    public void addToCartExtension() {
        int i= FakerMessageGenerator.generateNumberItem();
        ProductImage.get(i).hover();
        AddToCartIcon.get(i).click();
    }
}