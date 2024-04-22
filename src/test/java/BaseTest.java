import PageObject.MainPage;
import PageObject.LoginPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    public static final String login = "technopol42";
    public static final String password = "technopolisPassword";

    @BeforeAll
    public static void beforeMethod(){
        logger.info("Конфигурация браузера");
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Тестирования авторизации")
    public void loginTest(){
        logger.info("Начало теста loginTest");
        open("/", LoginPage.class).login(login, password);
    }

    @AfterAll
    public static void afterMethod(){
        logger.info("Выходим из аккаунта и закрываем браузер");
        MainPage mainPage = new MainPage();
        mainPage.logOut();
        Selenide.closeWebDriver();
    }
}
