import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$x;
public class LoginTest
{
    private final static String okUrl = "https://ok.ru/";
    private final static String login = "sidhfodfas";
    private final static String password = "asldkfhasd";
    @Test
    public void TestLogin()
    {
        LogPanel logPage = new LogPanel();
        logPage.LogPage(okUrl);
        logPage.LoginClick(login);
        logPage.LoginClick(password);
        logPage.SubmitClick();
        Assertions.assertTrue($x("//div[@class='input-e login_error']").isDisplayed());
    }
}