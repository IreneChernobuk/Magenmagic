package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.TestListeners;

import java.awt.*;

@Listeners(TestListeners.class)
public class BaseTest {
    @BeforeSuite
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
    }

    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        Selenide.clearBrowserCookies();
    }
}