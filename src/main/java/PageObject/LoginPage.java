package PageObject;
import PageObject.MainPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final SelenideElement loginBox = $(By.xpath("//input[@data-l='t,login']"));
    private final SelenideElement passwordBox = $(By.xpath("//input[@data-l='t,password']"));
    private final SelenideElement singnInButton = $(By.xpath("//input[@data-l='t,sign_in']"));
    public MainPage login(String login, String password){
        logger.info("Вводим данные пользователя");
        loginBox.shouldBe(visible).click();
        loginBox.sendKeys(login);
        passwordBox.shouldBe(visible).click();
        passwordBox.sendKeys(password);
        singnInButton.shouldBe(visible).click();
        sleep(1000);
        logger.info("Попытка авторизации");
        return page(MainPage.class);
    }
}
