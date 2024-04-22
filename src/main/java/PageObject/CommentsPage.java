package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CommentsPage {
    private static final Logger logger = LoggerFactory.getLogger(CommentsPage.class);
    private final SelenideElement inputField = $(By.xpath("//div[contains(@class, 'add-placeholder')]"));
    private final SelenideElement commentsButton = $(By.xpath("//a[@data-module='CommentWidgetsNew']"));
    private final SelenideElement smilesStrickers = $(By.xpath("//a[contains(@class, 'smiles')]"));
    private final SelenideElement smilesOnly = $(By.xpath("//a[@data-l='t,smilesTab']"));
    private final SelenideElement cheersSmile = $(By.xpath("//img[@alt=':-P']"));
    private final SelenideElement secondSmile = $(By.xpath("//img[@alt='(sc)']"));
    private final SelenideElement submitButton = $(By.xpath("//div[@uid='sendComment']"));
    private final ElementsCollection collection = $$(By.xpath("//div[@class='d_comment_text textWrap']"));
    public void addComment(String comment){
        logger.info("");
        commentsButton.shouldBe(visible).click();
        inputField.isDisplayed();
        inputField.setValue(comment);
        smilesStrickers.shouldBe(visible).click();
        smilesOnly.shouldBe(visible).click();
        cheersSmile.shouldBe(visible).click();
        secondSmile.shouldBe(visible).click();
        submitButton.shouldBe(visible).click();
    }
    public String getTextFromComment(){
        return collection.get(collection.size()-1).getText();
    }
    public void clearComment(){

    }
}
