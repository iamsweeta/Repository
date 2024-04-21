package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private final SelenideElement age = $(By.xpath("//span[@data-type='AGE']"));
    public String getTextFrom(){
        return age.getText();
    }

}
