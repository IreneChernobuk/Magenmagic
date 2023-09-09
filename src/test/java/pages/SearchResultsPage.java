package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private static final Logger LOGGER = LogManager.getLogger(SearchResultsPage.class.getName());
    private static final String TITLE_XPATH = "//a[contains(., '%s')]";

    @Step("Checking round result")
    public boolean checkFoundResult(String title) {
        String TitleFinalXpath = String.format(TITLE_XPATH, title);
        LOGGER.debug(String.format("Attempt to find: %s", title));
        return $(By.xpath(TitleFinalXpath)).isDisplayed();
    }
}