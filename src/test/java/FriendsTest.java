import Pages.BasePage;
import Pages.FriendPage;
import Pages.FriendsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FriendsTest extends BaseTest{
    String FIRST_NAME = "Иван";
    String LAST_NAME = "Иванов";
    @Test
    public void addFriendTest(){
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        FriendsPage friendsPage = basePage.goToFriendsPage();
        friendsPage.waitForLoad();
        friendsPage.addFriend(FIRST_NAME, LAST_NAME);
        Assertions.assertEquals("Запрос отправлен", friendsPage.getResultText());
    }

    @AfterAll
    public static void deleteReequest(){
        FriendPage friendPage = new FriendPage();
        friendPage.cancelRequest();
    }
}
