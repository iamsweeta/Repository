package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;

public class SettingsPage {
    private final SelenideElement privacy = $(By.xpath("//a[@data-l='t,privacy']"));
    private final ElementsCollection NewCollection = $$(By.xpath("//input[@checked='checked'][contains(@name, 'VISIBILITY')][@type='radio']"));
    private final SelenideElement saveButton = $(By.xpath("//div[contains(@class, 'form-action')]"));
    private final ElementsCollection collection = $$(By.xpath("//input[@value='1'][contains(@name, 'VISIBILITY')][@type='radio']"));
    private final ElementsCollection collectionNull = $$(By.xpath("//input[@value='0'][contains(@name, 'VISIBILITY')][@type='radio']"));

    public SettingsPage accessOnlyForFriends(){
        privacy.shouldBe(visible).click();
        System.out.println(collection.size());
        for(int i = 0; i<collection.size(); i++){
            collection.get(i).shouldBe(visible).click();
        }
        saveButton.shouldBe(visible).click();
        sleep(500);
        return this;
    }

    public List<Integer> getCollectionsOfValues(){
        List<Integer> valueList = new ArrayList<>();
        for(int i = 0; i<NewCollection.size(); i++){
            valueList.add(parseInt(NewCollection.get(i).getAttribute("value")));
        }
        return valueList;
    }
    public SettingsPage accessForAll(){
        for(int i = 0; i<collectionNull.size(); i++){
            collectionNull.get(i).shouldBe(visible).click();
        }
        saveButton.shouldBe(visible).click();
        return this;
    }
}