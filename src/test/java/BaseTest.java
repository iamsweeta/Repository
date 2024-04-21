import PageObject.MainPage;
import PageObject.LoginPage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void BeforeMethod(){
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void LoginTest(){
        String login = "technopol42";
        String password = "technopolisPassword";
        open("/", LoginPage.class).login(login, password);
    }

    @AfterAll
    public static void AfterMethod(){
        MainPage mainPage = new MainPage();
        mainPage.logOut();
        Selenide.closeWebDriver();
    }
}
