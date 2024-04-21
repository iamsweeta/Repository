package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LikePage {
    private final SelenideElement reactButton = $(By.xpath("//span[@data-module='ReactComponent']"));
    public LikePage LikeOrUnlikePost(){
        MainPage mainPage = new MainPage();
        LikePage likePage = mainPage.goToLikePage();
        reactButton.shouldBe(visible).click();
        sleep(500);
        return this;
    }
    public String getInnerText(){
        return reactButton.getText();
    }
}
