package pages;

import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement AccountElement = $(By.cssSelector(".account"));

    public void openMainPage(){
        open(Urls.URL_HOMEPAGE);
    }

    public void clickAccountElement(){
        AccountElement.click();
    }
}