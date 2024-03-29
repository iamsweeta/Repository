import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$x;
public class AssertTest
{
    @BeforeEach
    public void setUp()
    {
        Configuration.browser = "chrome";
        Configuration.browserSize ="1920x1080";
        Selenide.open("https://ok.ru/");
    }
    @Test
    public void AssertTest()
    {
        Assertions.assertTrue($x("//input[@id='field_email']").isDisplayed());
    }

    @AfterEach
    public void exit()
    {
        Selenide.closeWebDriver();
    }
}
