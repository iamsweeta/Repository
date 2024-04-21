import PageObject.MainPage;
import PageObject.FriendsPage;
import PageObject.ProfilePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FriendsTest extends BaseTest{
    @Test
    public void SearchTest(){
        String firstName = "Иван";
        String lastName = "Иванов";
        int age = 40;
        MainPage mainPage = new MainPage();
        FriendsPage friendsPage = mainPage.goToFriendsPage();
        friendsPage.searchFriend(firstName, lastName, age);
        ProfilePage profilePage = friendsPage.getText();
        System.out.println(profilePage.getTextFrom());
        Assertions.assertTrue(profilePage.getTextFrom().contains("40 лет"));
    }
}
