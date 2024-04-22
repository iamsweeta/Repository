import PageObject.MainPage;
import PageObject.FriendsPage;
import PageObject.ProfilePage;
import PageObject.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FriendsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(FriendsTest.class);
    @Test
    public void searchTest(){
        logger.info("Начало теста searchTest");
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
