import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.$x;


public class GroupsTest
{
    private final static String groupName = "Фандом Стаса Михайлова";
    @Test
    public void TestGroup()
    {
            InitPanel mainPage = new InitPanel();
            mainPage.GroupsClick();
            GroupsPanel groupPage = new GroupsPanel();
            groupPage.SetGroup(groupName);
            Assertions.assertTrue($x("//div[@class='group-name_t']/h1[@class='group-name_h']").isDisplayed());
    }
}