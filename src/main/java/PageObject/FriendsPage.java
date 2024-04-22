package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FriendsPage {
    //Расширенный поиск человека возрастом 40 лет
    private static final Logger logger = LoggerFactory.getLogger(FriendsPage.class);
    private final SelenideElement searchPanel = $(By.xpath("//input[@type='search']"));
    private final SelenideElement extandSearch = $(By.xpath("//a[@class='al fs-s']"));
    private final SelenideElement maleButton = $(By.xpath("//button[text()='Мужской']"));
    private final SelenideElement profile = $(By.xpath("//div[contains(@class, 'empty')]"));
    private final SelenideElement leftAgeBorder = $(By.xpath("//select[@name='st.fromAge']"));
    private final SelenideElement rightAgeBorder = $(By.xpath("//select[@name='st.tillAge']"));
    private final SelenideElement searchButton = $(By.xpath("//span[@name='ico_search_16']"));

    public FriendsPage searchFriend(String firstName, String lastName, int age){
        logger.info("Вводим имя и фамилию пользователя");
        searchPanel.shouldBe(visible).click();
        searchPanel.setValue(firstName+" "+lastName);
        sleep(100);
        logger.info("Начинаем поиск");
        searchButton.shouldBe(visible).click();
        sleep(1000);
        extandSearch.shouldBe(visible).click();
        logger.info("Вводим данные в расширенном поиске");
        maleButton.shouldBe(visible).click();
        leftAgeBorder.sendKeys(Integer.toString(age));
        rightAgeBorder.sendKeys(Integer.toString(age));
        sleep(1500);
        return this;
    }

    //Получаем возраст первого человека в списке
    public ProfilePage getText(){
        logger.info("Получаем возраст человека с его страницы");
        profile.shouldBe(visible).click();
        sleep(500);
        return page(ProfilePage.class);
    }
}
