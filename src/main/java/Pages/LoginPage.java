package Pages;

import Elemets.ButtonElement;
import Elemets.TextInputElement;
import LoadableComponent.LoadableComponent;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends LoadableComponent {
    TextInputElement LOGIN = new TextInputElement($(By.xpath("//input[@name='st.email']")));
    TextInputElement PASSWORD = new TextInputElement($(By.xpath("//input[@name='st.password']")));
    ButtonElement SIGN_IN = new ButtonElement($(By.xpath("//input[@data-l='t,sign_in']")));
    @Override
    public void waitForLoad(){
        System.out.println("Ожидание загрузки элементов");
        LOGIN.element()
                .shouldBe(visible);
        PASSWORD.element()
                .shouldBe(visible);
        SIGN_IN.element()
                .shouldBe(visible);
    }
    public BasePage login(String login, String password){
        System.out.println("Авторизация");
        LOGIN.element()
                .setValue(login);
        PASSWORD.element()
                .setValue(password);
        SIGN_IN.element()
                .click();
        return page(BasePage.class);
    }
}
