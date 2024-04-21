import PageObject.MainPage;
import PageObject.SettingsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class SettingsTest extends BaseTest{
    @Test
    public void SettingsTestMethod(){
        List<Integer> values = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1);
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.goToSettingsPage();
        settingsPage.accessOnlyForFriends();
        Assertions.assertEquals(values, settingsPage.getCollectionsOfValues());
    }
    @AfterAll
    public static void PreSettings(){
        SettingsPage settingsPage = new SettingsPage();
        settingsPage.accessForAll();
    }
}
