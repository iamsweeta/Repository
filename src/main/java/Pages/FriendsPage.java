package Pages;

import Elemets.ButtonElement;
import Elemets.CardElement;
import Elemets.TextBoxElement;
import Elemets.TextInputElement;
import LoadableComponent.LoadableComponent;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FriendsPage extends LoadableComponent {
    TextInputElement SEARCH_FRIENDS = new TextInputElement($(By.xpath("//input[@type='search']")));
    ButtonElement ADD_FRIEND = new ButtonElement($(By.xpath("//span[contains(@class, 'button-pro')]")));
    ButtonElement SEARCH_BUTTON = new ButtonElement($(By.xpath("//span[@name='ico_search_16']")));
    TextBoxElement RESUEST_SENT = new TextBoxElement($(By.xpath("//div[contains(@data-l, 'searchLocation')]")));
    CardElement FRIEND = new CardElement($(By.xpath("//a[contains(@data-l, 'searchAction')]")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки");
        SEARCH_FRIENDS.element()
                .shouldBe(visible);
        SEARCH_BUTTON.element()
                .shouldBe(visible);
    }
    public FriendsPage addFriend(String firstName, String lastName){
        System.out.println("Вводим имя пользователя в поиск");

        SEARCH_FRIENDS.click();
        sleep(100);
        SEARCH_FRIENDS.element()
                .setValue(firstName + " " + lastName);
        SEARCH_FRIENDS.element()
                        .sendKeys(Keys.ENTER);
        SEARCH_BUTTON.element()
                .click();
        System.out.println("Добавляем первого пользователя в списке в друзья");
        ADD_FRIEND.element()
                .shouldBe(visible)
                .click();
        sleep(300);
        return this;
    }

    public String getResultText(){
        return RESUEST_SENT.element()
                .shouldBe(visible)
                .getText();
    }

    public FriendPage goToFriendPage(){
        FRIEND.element()
                .shouldBe(visible)
                .click();
        return page(FriendPage.class);
    }
}
