import PageObject.CommentsPage;
import PageObject.MainPage;
import PageObject.UserPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentsTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CommentsTest.class);
    @Test
    public void addCommentTest(){
        logger.info("Начало теста addCommentTest");
        String expected = "Text";
        MainPage mainPage = new MainPage();
        CommentsPage commentsPage = mainPage.goToCommentsPage();
        commentsPage.addComment("Text");
        System.out.println(commentsPage.getTextFromComment());
        Assertions.assertTrue(commentsPage.getTextFromComment().contains(expected));
    }
}
