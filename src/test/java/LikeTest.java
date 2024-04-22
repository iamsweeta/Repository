import PageObject.LikePage;
import PageObject.MainPage;
import PageObject.UserPage;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LikeTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LikeTest.class);
    @Test
    public void likeMethod(){
        logger.info("Начало теста likeMethod");
        MainPage mainPage = new MainPage();
        LikePage likePage = mainPage.goToLikePage();
        likePage.LikeOrUnlikePost();
        Assertions.assertEquals(likePage.getInnerText(), "Класс");
    }

    @AfterAll
    public static void unlike(){
        logger.info("Начало after теста unlike");
        MainPage mainPage = new MainPage();
        LikePage likePage = mainPage.goToLikePage();
        likePage.LikeOrUnlikePost();
    }
}
