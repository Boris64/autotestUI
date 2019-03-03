package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement loginField = $(Selectors.byId("textfield-1009-inputEl"));
    private SelenideElement passwordField = $(Selectors.byId("textfield-1010-inputEl"));
    private SelenideElement okButton = $(Selectors.byXpath(".//span[@class='x-btn-icon-el  '][@id='button-1005-btnIconEl']"));


    @Step("Login as test user")
    public HomePage loginAsTestUser() {
        okButton.click();

        loginField.sendKeys("infobis");
        passwordField.sendKeys("dadomese");
        passwordField.pressEnter();

        try {
            okButton.waitUntil(Condition.visible, 10000);
        } catch (Exception e) {
            //element not has been appeared
        }

        if (okButton.isDisplayed()) {
            okButton.click();
        }
        return page(HomePage.class);
    }
}
