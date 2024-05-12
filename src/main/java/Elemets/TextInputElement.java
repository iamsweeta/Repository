package Elemets;

import com.codeborne.selenide.SelenideElement;

public class TextInputElement extends BaseElement{
    private SelenideElement TEXT_INPUT;
    public TextInputElement(SelenideElement TEXT_INPUT){
        super(TEXT_INPUT);
    }
    public void input(String text){
        TEXT_INPUT.setValue(text);
    }
}
