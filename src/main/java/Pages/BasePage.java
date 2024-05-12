package Pages;

import Elemets.ButtonElement;
import Elemets.SectionElement;
import LoadableComponent.LoadableComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BasePage extends LoadableComponent {
    private final ButtonElement MENU = new ButtonElement($(By.xpath("//button[contains(@aria-controls, 'menu')]")));
    private final SectionElement USER_SECTION = new SectionElement($(By.xpath("//a[@data-l='t,userPage']")));
    private final SectionElement FRIENDS_SECTION = new SectionElement($(By.xpath("//a[@data-l='t,userFriend']")));
    private final SectionElement GROUPS_SECTION = new SectionElement($(By.xpath("//a[@data-l='t,userAltGroup']")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        MENU.element().shouldBe(visible);
        USER_SECTION.element().shouldBe(visible);
        FRIENDS_SECTION.element().shouldBe(visible);
        GROUPS_SECTION.element().shouldBe(visible);
    }
    public MenuPage goToMenuPage(){
        System.out.println("  Переходим в меню");
        MENU.element()
                .click();
        return page(MenuPage.class);
    }
    public FriendsPage goToFriendsPage(){
        System.out.println("  Переходим на страницу с друзьями");
        FRIENDS_SECTION.element()
                .shouldHave(text("Друзья"))
                .click();
        return page(FriendsPage.class);
    }

    public GroupsPage goToGroupsPage(){
        System.out.println("  Переходим на страницу с группами");
        GROUPS_SECTION.element()
                .shouldHave(text("Группы"))
                .click();
        return page(GroupsPage.class);
    }

    public UserPage goToUserPage(){
        System.out.println("  Переходим на страницу пользователя");
        USER_SECTION.element()
                .click();
        return page(UserPage.class);
    }
}
