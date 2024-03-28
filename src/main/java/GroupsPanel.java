import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GroupsPanel {
    private final SelenideElement createGroup = $x("//a[contains(@class, 'portlet_h_ac')");
    private final SelenideElement groupType = $x("//a[contains(@class, 'create-group-dialog-v2_i')]");
    private final SelenideElement groupName = $x("//input[@id='field_name']");
    private final SelenideElement groupTypeField = $(By.id("'group_type'"));
    private final SelenideElement groupTypeOption = $x("//option[@value='public']");
    private final SelenideElement groupCreate = $x("//input@id='hook_FormButton_button_create' ");


    public void SetGroup(String name)
    {
        createGroup.click();
        groupType.click();
        groupName.click();
        groupName.setValue(name);
        groupTypeField.click();
        groupTypeOption.click();
        groupCreate.click();
    }

}