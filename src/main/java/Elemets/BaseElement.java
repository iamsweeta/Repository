package Elemets;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;

public abstract class BaseElement {
    private SelenideElement ELEMENT;
    public BaseElement(SelenideElement ELEMENT){
        this.ELEMENT = ELEMENT;
    }
    public void click(){
        ELEMENT.click();
    }

    public void doubleClick(){
        ELEMENT.click();
        ELEMENT.click();
    }
    public SelenideElement element(){
        return ELEMENT;
    }
}
