import Pages.BasePage;
import Pages.LoginPage;
import Pages.MenuPage;
import ValueObjects.UserData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    UserData userData = new UserData("technopolisPassword","technopol42");

    @BeforeAll
    public static void config(){
        System.out.println("Конфигурация браузера");
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void loginTest(){
        open("/", LoginPage.class).waitForLoad();
        LoginPage loginPage = new LoginPage();
        loginPage.login(userData.getLogin(), userData.getPassword());
    }

    @AfterAll
    public static void logout(){
        System.out.println("Выход из аккаунта:");
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        MenuPage menuPage = basePage.goToMenuPage();
        menuPage.waitForLoad();
        menuPage.log_out();
        Selenide.closeWebDriver();
    }
}
