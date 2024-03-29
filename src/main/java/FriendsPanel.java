import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
public class FriendsPanel
{
    private final SelenideElement searchBar = $("//input[@type='search']");
    private final SelenideElement searchButton = $("svg[@viewBox='0 0 16 16'");
    private final SelenideElement addFriend = $("//span[text()='Добавить в друзья']");

    public void MakeFriendCeleb(String celebName)
        {
            searchBar.click();
            searchBar.setValue(celebName);
            searchButton.click();
            addFriend.click();
        }
}
