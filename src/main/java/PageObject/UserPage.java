package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class UserPage {
    private final static SelenideElement longBioField = $(By.xpath("//div[@data-l='t,textField-text']"));
    private final static SelenideElement longBioArea = $(By.xpath("//textarea[@class='text-field_editor']"));
    private final static SelenideElement expandableField = $(By.xpath("//div[contains(@class, 'expandable')]"));
    private final static SelenideElement saveButton = $(By.xpath("//button[@data-l='t,textField-save']"));

    static String firstLongBio;

    //Устанавливаем новое значение статуса
    public UserPage addLongBio(String longBio){
        sleep(2000);
        longBioArea.isDisplayed();
        firstLongBio = longBioArea.getOwnText();
        if (expandableField.isDisplayed()){
            expandableField.click();
        }
        longBioField.isDisplayed();
        longBioField.click();
        longBioArea.setValue(longBio);
        saveButton.shouldBe(visible).click();
        Selenide.refresh();
        return this;
    }

    //Получаем длину нового статуса после обновления страницы
    public int getTextLengthFromLongBio(){
        return longBioArea.getOwnText().length();
    }

    //Устанавиваем прежнее значение статуса
    public UserPage ResetBio(){
        sleep(1500);
        longBioArea.isDisplayed();
        if (expandableField.isDisplayed()){
            expandableField.click();
        }
        longBioField.isDisplayed();
        longBioField.click();
        longBioArea.setValue(firstLongBio);
        saveButton.shouldBe(visible).click();
        return this;
    }
}
