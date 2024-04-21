import PageObject.MainPage;
import PageObject.UserPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest extends BaseTest{

    //Проверяем не превышает ли текст длиной больше 150 символов 150 символов после обновления страницы
    @Test
    public void UserInfoTest(){
        String longBio = "Существуют две основные трактовки понятия «текст»: имманентная (расширенная, философски нагруженная)" +
                "и репрезентативная (более частная). Имманентный подход подразумевает отношение к тексту как к автономной реальности," +
                "нацеленность на выявление его внутренней структуры." +
                "Репрезентативный — рассмотрение текста как особой формы представления информации о внешней тексту действительности.";
        MainPage mainPage = new MainPage();
        UserPage userPage = mainPage.goToUserPage();
        userPage.addLongBio(longBio);
        int lenght = userPage.getTextLengthFromLongBio();
        Assertions.assertEquals(150, lenght);
    }

    @AfterAll
    public static void Reset(){
        UserPage userPage = new UserPage();
        userPage.ResetBio();
    }
}
