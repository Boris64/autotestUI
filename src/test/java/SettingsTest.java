import Objects.Menu;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SettingsPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.AssertionMode.SOFT;

//@Listeners({SoftAsserts.class})
public class SettingsTest {
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        //Configuration.assertionMode = SOFT;
        Configuration.timeout = 6000;
        LoginPage loginPage = Selenide.open("https://test2.agrosignal.com/", LoginPage.class);
        homePage = loginPage.loginAsTestUser();
        homePage.viewNews();
    }

    @Test
    public void settingsTest1() {
        SettingsPage settingsPage = homePage.openSettings();
        settingsPage.validateMenus(

                new Menu("Биллинг. Плательшики"),
                new Menu("Биллинг. Тарифы"),
                new Menu("Начисления",true),
                new Menu("Накладные"),
                new Menu("Остатки по складам",true),
                new Menu("Перемещения по складам",true),
                new Menu("Весовые"),
                new Menu("Весовые смены",true,30000),
                new Menu("Взвешивания",true),
                new Menu("Контрагенты"),
                new Menu("Организации"),
                new Menu("Покупатели"),
                new Menu("Геозоны"),
                new Menu("Места назначения"),
                new Menu("Места хранения"),
                new Menu("Элеваторы"),
                new Menu("Виды работ"),
                new Menu("Контроль входа и выхода ТС",true),
                new Menu("Контроль скорости"),
                new Menu("Смены работ"),
                new Menu("Транспортные маршруты"),
                new Menu("Групповой график работ",true, 40000),
                new Menu("Групповые оперативные планы",true),
                new Menu("Ежегодные планы",true),
                new Menu("Оперативные планы",true),
                new Menu("Базовые культуры"),
                new Menu("Группы товаров"),
                new Menu("Культуры"),
                new Menu("Технологии"),
                new Menu("Тип культуры"),
                new Menu("Товары"),
                new Menu("Должности"),
                new Menu("Персонал"),
                new Menu("Пользователи"),
                new Menu("Навесные агрегаты"),
                new Menu("Прицепы"),
                //new Menu("Типы навесных агрегатов"),
                new Menu("Охраняемые объекты"),
                new Menu("Приборы"),
                new Menu("Список ключей-таблеток"),
                new Menu("Техника", false, 40000),
                new Menu("Тип ТС"),
                new Menu("Выполненные с/х работы",true, 40000),
                new Menu("Единицы измерения работ"),
                new Menu("Исключенные работы",true),
                new Menu("Особые условия работы"),
                new Menu("Расценки",true),
                new Menu("Типы расценок"),
                new Menu("События"),
                new Menu("Уведомления"),
                new Menu("Заметки"),
                new Menu("Поручения"),
                new Menu("Типы простоев"),
                //new Menu("Шаблоны форм"),
                new Menu("Значения счетчиков",true),
                new Menu("Лимиты счетчиков",true),
                new Menu("Ложные движения топлива"),
                new Menu("Получатель топлива вручную",true),
                new Menu("Техническое обслуживание")

        );

    }

}

