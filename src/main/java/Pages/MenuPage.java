package Pages;

import Elemets.ButtonElement;
import LoadableComponent.LoadableComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MenuPage extends LoadableComponent {
    private final ButtonElement LOG_OUT = new ButtonElement($(By.xpath("//a[@data-l='t,logout']")));
    private final ButtonElement LOG_OUT2 = new ButtonElement($(By.xpath("//input[@data-l='t,logout']")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        LOG_OUT.element().shouldBe(visible);
    }
    public void log_out(){
        System.out.println("Нажимаем выйти");
        LOG_OUT.element()
                .shouldHave(text("Выйти"))
                .click();
        LOG_OUT2.element()
                .shouldBe(visible)
                .click();
    }
}
