package Pages;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import Elemets.ButtonElement;
import Elemets.TextBoxElement;
import LoadableComponent.LoadableComponent;
import org.openqa.selenium.By;

public class FriendPage extends LoadableComponent {
    TextBoxElement REQUEST = new TextBoxElement($(By.xpath("//li[contains(@class, 'u-menu_li view')]")));
    ButtonElement CANCEL = new ButtonElement($(By.xpath("//a[@aria-label='Отменить запрос']")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        REQUEST.element()
                .shouldBe(visible);
    }
    public FriendPage cancelRequest(){
        System.out.println("Отменяем заявку в друзья");
        REQUEST.element()
                .click();

        CANCEL.element()
                .shouldBe(visible)
                .click();
        return this;
    }

}
