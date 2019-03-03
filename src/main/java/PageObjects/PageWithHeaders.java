package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageWithHeaders {

    protected SelenideElement settingsButton = $(Selectors.byXpath(".//span[@class='x-btn-icon-el  '][@id='idReferences-btnIconEl']"));
    protected SelenideElement reference = $(Selectors.byId("referenceStatus-btnIconEl"));
    protected SelenideElement news = $(Selectors.byText("Новости"));
    protected SelenideElement closeNews = $(Selectors.byId("tool-1648-toolEl"));
    private final SelenideElement spinnerLocator = $(Selectors.byXpath(".//div[@class='x-mask-msg-text'][contains(text(), 'Загрузка данных')]"));

    public PageWithHeaders viewNews() {
        spinnerLocator.shouldBe(Condition.appears);
        spinnerLocator.waitUntil(Condition.disappears,20000);
        reference.shouldBe(Condition.and("clickable",Condition.visible, Condition.enabled)).click();
        news.shouldBe(Condition.visible).click();
        closeNews.shouldBe(Condition.visible).click();

        return this;
    }

    public SettingsPage openSettings() {
        settingsButton.click();
        return page(SettingsPage.class);
    }

}
