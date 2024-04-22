package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);
    private final SelenideElement menu = $(By.xpath("//button[contains(@aria-controls, 'menu')]"));
    private final SelenideElement userPanel = $(By.xpath("//a[@data-l='t,userPage']"));
    private final SelenideElement logOut = $(By.xpath("//button[contains(@aria-controls, 'menu')]"));
    private final SelenideElement friendsButtton = $(By.xpath("//a[@data-l='t,userFriend']"));
    private final SelenideElement changeSettings = $(By.xpath("//span[@class='u-menu_tx ellip-i lp']"));
    public void logOut(){
        menu.shouldBe(visible).click();
    }

    public SettingsPage goToSettingsPage(){
        logger.info("Переходим в настройки");
        menu.shouldBe(visible).click();
        changeSettings.shouldBe(visible).click();
        sleep(2000);
        return page(SettingsPage.class);
    }

    public FriendsPage goToFriendsPage(){
        logger.info("Переходим на страницу поиска друзей");
        friendsButtton.shouldBe(visible).click();
        sleep(100);
        return page(FriendsPage.class);
    }

    public UserPage goToUserPage(){
        logger.info("Переходим на страницу пользователя");
        userPanel.shouldBe(visible).click();
        sleep(100);
        return page(UserPage.class);
    }
    public LikePage goToLikePage(){
        return page(LikePage.class);
    }

    public CommentsPage goToCommentsPage(){
        return page(CommentsPage.class);
    }
}
