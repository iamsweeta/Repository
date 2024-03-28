import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
public class LogPanel
{
    private final SelenideElement login = $x("//input[@id='field_email']");
    private final SelenideElement password = $x("//input[@name='st.password']");
    private final SelenideElement submit = $x("//input[@value='Войти в Одноклассники'");
    public void LogPage(String link)
    {
        Selenide.open(link);
    }
    public void LoginClick(String log)
    {
        login.setValue(log);
    }
    public void PasswordClick(String pass)
    {
        password.setValue(pass);
    }
    public void SubmitClick()
    {
        submit.click();
    }
}