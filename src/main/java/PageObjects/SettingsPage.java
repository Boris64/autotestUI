package PageObjects;

import Objects.Menu;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.SoftAssertionError;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.Listeners;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SettingsPage extends PageWithHeaders {
    private final String settingsMenuLocator = ".//span[@class='x-tree-node-text '][text() = '%s']";
    private final String spinnerLocator = ".//div[@class='x-mask-msg-text'][contains(text(), 'Загрузка справочника: %s')]";
    //private ElementsCollection addButton = $$(Selectors.byText("Добавить"));
    private SelenideElement okButton = $(Selectors.byText("Ок"));

    @Step("Validate menu with name {0}")
    private SettingsPage validateMenuByName(Menu menu) {
        $(Selectors.byXpath(String.format(settingsMenuLocator, menu.getName()))).scrollTo().click();

        if (menu.getShouldOkBePresent()) {
            okButton.shouldBe(Condition.visible);
            okButton.doubleClick();
        }

        try {
            $(Selectors.byXpath(String.format(spinnerLocator, menu.getName()))).shouldBe(Condition.appears);
            $(Selectors.byXpath(String.format(spinnerLocator, menu.getName()))).waitUntil(Condition.disappears, menu.getTimeout());
        }
        catch (ElementShould e) {

        }
        $(Selectors.byXpath(String.format(settingsMenuLocator, menu.getName()) + "/../../..")).shouldBe(Condition.cssClass("x-grid-row-selected"));

        return this;
    }

    @Step("Validate menus")
    public SettingsPage validateMenus(Menu... menus) {
        for (Menu menu : menus) {
            validateMenuByName(menu);
        }
        return this;
    }
}
