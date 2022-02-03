package org.example;

import org.example.Pages.LoginPage;
import org.example.Pages.MainPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class YMailTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;

    @BeforeClass
    public static void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        try {
            driver = new RemoteWebDriver(new URL(ConfProperties.getProperty("url")), chromeOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void checkAndSendTest(){
        //переход на страницу авторизации
        loginPage.pickLoginBtn();
        //авторизация
        loginPage.enterLogin(ConfProperties.getProperty("login"));
        loginPage.pressEnter();
        loginPage.enterPassword(ConfProperties.getProperty("password"));
        loginPage.pressEnter();
        //поиск темы
        mainPage.inputTheme(ConfProperties.getProperty("theme"));
        mainPage.clickFind();
        //поиск только по входящим
        mainPage.clickFolders();
        mainPage.pickInbox();
        mainPage.clickFind();
        //количество писем с искомой темой
        String amountOfMails = mainPage.amountOfMails();
        //отправка сообщения с количеством сообщений на свою почту
        mainPage.writeMessage();
        mainPage.inputReceiver(ConfProperties.getProperty("login"));
        mainPage.setTheme(ConfProperties.getProperty("themeSurname"));
        mainPage.inputMessage(amountOfMails);
        mainPage.sendMessage();


    }

    @AfterClass()
    public static void tearDown() {
        driver.quit();
    }

}
