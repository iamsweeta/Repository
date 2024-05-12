import Pages.BasePage;
import Pages.GroupsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupsTest extends BaseTest{
    @Test
    public void joinGroupTest(){
        BasePage basePage = new BasePage();
        basePage.waitForLoad();
        GroupsPage groupsPage = basePage.goToGroupsPage();
        groupsPage.waitForLoad();
        groupsPage.joinGroup();
        Assertions.assertEquals("Вы в группе", groupsPage.getResultText());
    }
}
