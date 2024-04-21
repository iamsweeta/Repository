import PageObject.LikePage;
import PageObject.MainPage;
import org.junit.jupiter.api.*;

public class LikeTest extends BaseTest {
    @Test
    public void LikeMethod(){
        MainPage mainPage = new MainPage();
        LikePage likePage = mainPage.goToLikePage();
        likePage.LikeOrUnlikePost();
        Assertions.assertEquals(likePage.getInnerText(), "Класс");
    }

    @AfterAll
    public static void Unlike(){
        MainPage mainPage = new MainPage();
        LikePage likePage = mainPage.goToLikePage();
        likePage.LikeOrUnlikePost();
    }
}
