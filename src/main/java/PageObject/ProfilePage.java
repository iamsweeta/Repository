package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);
    private final SelenideElement age = $(By.xpath("//span[@data-type='AGE']"));
    public String getTextFrom(){
        logger.info("Получаем возраст человека с его страницы");
        return age.getText();
    }

}
