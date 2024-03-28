import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class InitPanel
{
    private final SelenideElement exit = $x(".//div[@role='listitem']");
    private final SelenideElement exitButton = $x("//a[contains(text(),'Выйти')]");
    private final SelenideElement secondExitButton = $x("//input[@data-l='t,logout']");
    private final SelenideElement properties = $x("//button[@aria-label='Настройки профиля']");
    private final SelenideElement user = $x("//span[@class='ucard-mini_cnt']");
    private final SelenideElement friends = $x("//a[@data-l='t,userFriend']]");
    private final SelenideElement groups = $x("//a[@data-l='t,userAltGroup']");
    //


    public void PropsClick()
    {
        user.click();
        properties.click();

    }

    public void GroupsClick()
    {
        groups.click();
    }
    public void FriendsClick()
    {
        friends.click();
    }
    public void exit(){
        user.click();
        exit.click();
        exitButton.isDisplayed();
        exitButton.click();
        secondExitButton.isDisplayed();
        secondExitButton.click();
    }
}