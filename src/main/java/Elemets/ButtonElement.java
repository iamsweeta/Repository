package Elemets;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;

public class ButtonElement extends BaseElement{
    private SelenideElement BUTTON;
    public ButtonElement(SelenideElement BUTTON){
        super(BUTTON);
    }
}
