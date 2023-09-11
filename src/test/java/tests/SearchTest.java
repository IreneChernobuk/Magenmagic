package tests;

import io.qameta.allure.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultsPage;

@Epic("Smoke")
@Feature("Search")
@Story("Search Title Extension")
public class SearchTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class.getName());
    String titleExtension = "Product Popularity Status";

    @Description("Search Title Extension")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void searchTitleExtensionTest() {
        MainPage mainPage = new MainPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        mainPage.openMainPage();
        LOGGER.info(String.format("Page %s opened", MainPage.class.getName()));
        mainPage.inputSearchField(titleExtension);
        LOGGER.info(String.format("Input %s 'Search' field", titleExtension));
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        Assert.assertTrue(searchResultsPage.checkFoundResult(titleExtension), "Element wasn't found on the page");
        LOGGER.info("Element was found on the page");
    }
}