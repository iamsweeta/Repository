import PageObject.MainPage;
import PageObject.SettingsPage;
import PageObject.UserPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class SettingsTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(SettingsPage.class);
    @Test
    public void settingsTestMethod(){
        logger.info("Начало теста settingsTestMethod");
        List<Integer> values = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1);
        MainPage mainPage = new MainPage();
        SettingsPage settingsPage = mainPage.goToSettingsPage();
        settingsPage.accessOnlyForFriends();
        Assertions.assertEquals(values, settingsPage.getCollectionsOfValues());
    }
    @AfterAll
    public static void preSettings(){
        logger.info("Начало after теста preSettings");
        SettingsPage settingsPage = new SettingsPage();
        settingsPage.accessForAll();
    }
}
