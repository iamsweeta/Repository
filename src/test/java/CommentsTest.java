import PageObject.CommentsPage;
import PageObject.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentsTest extends BaseTest {
    @Test
    public void AddCommentTest(){
        String expected = "Text";
        MainPage mainPage = new MainPage();
        CommentsPage commentsPage = mainPage.goToCommentsPage();
        commentsPage.addComment("Text");
        System.out.println(commentsPage.getTextFromComment());
        Assertions.assertTrue(commentsPage.getTextFromComment().contains(expected));
    }
}
