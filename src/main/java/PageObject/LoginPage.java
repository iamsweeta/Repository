package PageObject;
import PageObject.MainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginBox = $(By.xpath("//input[@data-l='t,login']"));
    private final SelenideElement passwordBox = $(By.xpath("//input[@data-l='t,password']"));
    private final SelenideElement singnInButton = $(By.xpath("//input[@data-l='t,sign_in']"));
    public MainPage login(String login, String password){
        loginBox.shouldBe(visible).click();
        loginBox.sendKeys(login);
        passwordBox.shouldBe(visible).click();
        passwordBox.sendKeys(password);
        singnInButton.shouldBe(visible).click();
        sleep(1000);
        return page(MainPage.class);
    }
}
