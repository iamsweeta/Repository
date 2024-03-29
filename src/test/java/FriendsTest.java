import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FriendsTest
{
    private final static String celebName = "Стас Михайлов";

    @Test
    public void TestFriends()
    {
        InitPanel mainPage = new InitPanel();
        mainPage.FriendsClick();
        FriendsPanel friendsPanel = new FriendsPanel();
        friendsPanel.MakeFriendCeleb(celebName);
        Assertions.assertTrue($x("//div[@class='modal-new_cnt']").isDisplayed());
        SelenideElement closeButton = $("//input[@id='buttonId_button_close']");
        closeButton.click();
    }
}
