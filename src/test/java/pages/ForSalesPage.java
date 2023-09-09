package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class ForSalesPage {
    private static final Logger LOGGER = LogManager.getLogger(ForSalesPage.class.getName());
    private ElementsCollection SEEMOREBUTTON = $$(By.className("seeMore"));

    @Step("Click 'See More' Button")
    public void clickSeeMoreExtension() {
        LOGGER.debug(String.format("Attempt to click element: %s", SEEMOREBUTTON));
        SEEMOREBUTTON.get(0).click();
    }
}