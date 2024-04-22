package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserPage {
    private static final Logger logger = LoggerFactory.getLogger(UserPage.class);
    private final static SelenideElement longBioField = $(By.xpath("//div[@data-l='t,textField-text']"));
    private final static SelenideElement longBioArea = $(By.xpath("//textarea[@class='text-field_editor']"));
    private final static SelenideElement expandableField = $(By.xpath("//div[contains(@class, 'expandable')]"));
    private final static SelenideElement saveButton = $(By.xpath("//button[@data-l='t,textField-save']"));

    static String firstLongBio;

    //Устанавливаем новое значение статуса
    public UserPage addLongBio(String longBio){
        sleep(2000);
        longBioArea.isDisplayed();
        logger.info("Сохраняем текущий статус");
        firstLongBio = longBioArea.getOwnText();
        logger.info("Вводим новое значение статуса");
        if (expandableField.isDisplayed()){
            expandableField.click();
        }
        longBioField.isDisplayed();
        longBioField.click();
        longBioArea.setValue(longBio);
        saveButton.shouldBe(visible).click();
        logger.info("Пробуем установить новое значение статуса");
        Selenide.refresh();
        return this;
    }

    //Получаем длину нового статуса после обновления страницы
    public int getTextLengthFromLongBio(){
        logger.info("Получаем длину статуса после обновления страницы");
        return longBioArea.getOwnText().length();
    }

    //Устанавиваем прежнее значение статуса
    public UserPage ResetBio(){
        sleep(1500);
        logger.info("Вводим прежнее значение статуса");
        longBioArea.isDisplayed();
        if (expandableField.isDisplayed()){
            expandableField.click();
        }
        longBioField.isDisplayed();
        longBioField.click();
        longBioArea.setValue(firstLongBio);
        saveButton.shouldBe(visible).click();
        logger.info("Пробуем установить прежнее значение статуса");
        return this;
    }
}
