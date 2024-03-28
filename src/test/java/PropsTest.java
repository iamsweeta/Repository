import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class PropsTest
{
    @Test
    public void TestProps()
    {
        InitPanel mainPage = new InitPanel();
        mainPage.PropsClick();
        PropsPanel propsPage = new PropsPanel();
        propsPage.changeTheme();
        Assertions.assertTrue(propsPage.PropsResults().equals("Тёмная"));
    }
}
