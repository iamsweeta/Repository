import Pages.BasePage;
import Pages.UserPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatusTest extends BaseTest {
    @Test
    public void userInfoTest(){
        String STATUS = "Этот текст содержит более ста пятидесяти символов, граница размера статуса - 150 символов." +
                "Selenium uses the native support implemented by each browser to carry out the automation process." +
                "For this reason, Selenium users need to place a component called driver (chromedriver, geckodriver, msedgedriver, etc.)" +
                "between the script using the Selenium API and the browser. For many years, managing these drivers was a manual process" +
                "for Selenium users";

        BasePage basePage = new BasePage();
        UserPage userPage = basePage.goToUserPage();
        userPage.changeStatus(STATUS);
        int lenght = userPage.getNewStatusLenght();
        Assertions.assertEquals(150, lenght);
    }

    @AfterAll
    public static void returnPreviousStatus(){
        UserPage userPage = new UserPage().returnPreviosStatus();
    }
}
