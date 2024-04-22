package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LikePage {
    private static final Logger logger = LoggerFactory.getLogger(LikePage.class);
    private final SelenideElement reactButton = $(By.xpath("//span[@data-module='ReactComponent']"));
    public LikePage LikeOrUnlikePost(){
        logger.info("Нажимаем на кнопку класс первого поста в ленте");
        reactButton.shouldBe(visible).click();
        sleep(500);
        return this;
    }
    public String getInnerText(){
        logger.info("Получаем текст из элемента");
        return reactButton.getText();
    }
}
