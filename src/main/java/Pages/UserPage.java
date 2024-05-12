package Pages;

import Elemets.ButtonElement;
import Elemets.TextBoxElement;
import Elemets.TextInputElement;
import LoadableComponent.LoadableComponent;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserPage extends LoadableComponent {
    private String PREVIOS_STATUS;
    private final TextBoxElement STATUS_BOX = new TextBoxElement($(By.xpath("//div[@data-l='t,textField-text']")));
    private final TextBoxElement LONG_STATUS_BOX = new TextBoxElement($(By.xpath("//div[contains(@class, 'expandable')]")));
    private final TextInputElement STATUS = new TextInputElement($(By.xpath("//textarea[@class='text-field_editor']")));
    private final ButtonElement SAVE_BUTTON = new ButtonElement($(By.xpath("//button[@data-l='t,textField-save']")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        STATUS_BOX.element()
                .shouldBe(visible);
    }
    public UserPage changeStatus(String newStatus){
        System.out.println("Сохраняем предыдущий статус в отдельной переменной");
        PREVIOS_STATUS = STATUS.element()
                .getText();

        System.out.println("Меняем статус");

        if (LONG_STATUS_BOX.element().isDisplayed()) {
            LONG_STATUS_BOX.element()
                           .click();
        }

        STATUS_BOX.element()
                .click();
        STATUS.element()
                .setValue(newStatus);

        System.out.println("Сохраняем новый статус");
        SAVE_BUTTON.element()
                .shouldBe(visible)
                .click();

        System.out.println("Обновление страницы");
        Selenide.refresh();
        return this;
    }
    public String getPreviosStatus(){
        System.out.println("Возвращаем значение предыдущего статуса");
        return PREVIOS_STATUS;
    }

    public int getNewStatusLenght(){
        System.out.println("Получаем длину текущего статуса");
        return STATUS_BOX.element()
                .shouldBe(visible)
                .getText()
                .length();
    }

    public UserPage returnPreviosStatus(){
        if (LONG_STATUS_BOX.element().isDisplayed()) {
            LONG_STATUS_BOX.element()
                    .click();
        }
        STATUS_BOX.element()
                .click();
        STATUS.element()
                .setValue(PREVIOS_STATUS);

        System.out.println("Сохраняем старый статус");
        SAVE_BUTTON.element()
                .shouldBe(visible)
                .click();

        System.out.println("Обновление страницы");
        return this;
    }
}
