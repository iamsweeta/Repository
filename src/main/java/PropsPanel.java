import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PropsPanel {
    private final SelenideElement interfaceTheme = $x("//span[@class='user-settings_i_tx theme-switcher_container']");
    private final SelenideElement blackTheme = $x("//span[text()='Тёмная']");

    public void changeTheme()
    {
        interfaceTheme.click();
        blackTheme.click();
    }
    public String PropsResults()
    {
        return interfaceTheme.getText();
    }
}