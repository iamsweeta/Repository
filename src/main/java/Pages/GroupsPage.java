package Pages;

import Elemets.ButtonElement;
import Elemets.CardElement;
import Elemets.TextBoxElement;
import LoadableComponent.LoadableComponent;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends LoadableComponent {
    private final CardElement FIRST_GROUP = new CardElement($(By.xpath("//a[@class='group-detailed-card_name']")));
    private final ButtonElement JOIN_BUTTON = new ButtonElement(($(By.xpath("//span[contains(@class,'button-core')]"))));
    private final TextBoxElement JOIN_RESULT = new TextBoxElement($(By.xpath("//div[contains(@class, 'join-result')]")));

    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        FIRST_GROUP.element()
                .shouldBe(visible);
        JOIN_BUTTON.element()
                .shouldBe(visible);
    }

    public GroupsPage joinGroup(){
        System.out.println("Вступаем в группу");
        JOIN_BUTTON.doubleClick();
        return this;
    }

    public String getResultText(){
        System.out.println("Получаем текст с результатом");
        return JOIN_RESULT.element()
                .getText();
    }
}
