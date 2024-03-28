import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.codeborne.selenide.*;


public class BeforeTest
{
    private final static String okUrl = "https://ok.ru/";
    private final static String login = "technopol42";
    private final static String password = "technopolisPassword";

    @BeforeEach
    public void setUp()
    {
        Configuration.browser = "chrome";
        Configuration.browserSize ="1920x1080";
    }
    @BeforeEach
    public void init()
    {
        setUp();
        logIn();
    }
    public void logIn()
    {
        LogPanel loginPage = new LogPanel();
        loginPage.LogPage(okUrl);
        loginPage.LoginClick(login);
        loginPage.PasswordClick(password);
        loginPage.SubmitClick();
    }
    @AfterEach
    public void exitAll()
    {
        new InitPanel().exit();
        Selenide.closeWebDriver();
    }
}