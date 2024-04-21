package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement menu = $(By.xpath("//button[contains(@aria-controls, 'menu')]"));
    private final SelenideElement userPanel = $(By.xpath("//a[@data-l='t,userPage']"));
    private final SelenideElement logOut = $(By.xpath("//button[contains(@aria-controls, 'menu')]"));
    private final SelenideElement friendsButtton = $(By.xpath("//a[@data-l='t,userFriend']"));
    public void logOut(){
        menu.shouldBe(visible).click();
    }

    public SettingsPage goToSettingsPage(){
        SelenideElement changeSettings = $(By.xpath("//span[@class='u-menu_tx ellip-i lp']"));
        menu.shouldBe(visible).click();
        changeSettings.shouldBe(visible).click();
        sleep(2000);
        return page(SettingsPage.class);
    }

    public FriendsPage goToFriendsPage(){
        friendsButtton.shouldBe(visible).click();
        sleep(100);
        return page(FriendsPage.class);
    }

    public UserPage goToUserPage(){
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
