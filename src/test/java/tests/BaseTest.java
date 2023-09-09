package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import pages.AccountPage;

import java.awt.*;

public class BaseTest {
    @BeforeSuite
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
        Selenide.clearBrowserCookies();
    }
}